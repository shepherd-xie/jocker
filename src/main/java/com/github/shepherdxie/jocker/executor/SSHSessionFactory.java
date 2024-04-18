package com.github.shepherdxie.jocker.executor;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shepherd Xie
 * @since 2024/4/16
 */
@Slf4j
public class SSHSessionFactory {
    public static Session withPassword(String hostname, String username, int port, String password) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(username, hostname, port);
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");

        log.info("Connected to {} via SSH using password authentication.", hostname);
        return session;
    }

    public static Session withPrivateKey(String hostname, String username, int port, String privateKey) {
        JSch jsch = new JSch();
        Session session = null;
        try {
            jsch.addIdentity(privateKey); // 加载私钥文件
            session = jsch.getSession(username, hostname, port);
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }

        session.setConfig("StrictHostKeyChecking", "no"); // 关闭主机密钥检查

        log.info("Connected to {} via SSH using key authentication.", hostname);
        return session;
    }
}
