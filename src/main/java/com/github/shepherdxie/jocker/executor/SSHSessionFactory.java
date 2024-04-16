package com.github.shepherdxie.jocker.executor;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * @author Shepherd Xie
 * @since 2024/4/16
 */
class SSHSessionFactory {
    public Session withPassword(String hostname, String username, int port, String password) throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, hostname, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");

        System.out.println("Connected to " + hostname + " via SSH using password authentication.");
        return session;
    }

    public Session withPrivateKey(String hostname, String username, int port, String privateKey) throws JSchException {
        JSch jsch = new JSch();
        jsch.addIdentity(privateKey); // 加载私钥文件

        Session session = jsch.getSession(username, hostname, port);
        session.setConfig("StrictHostKeyChecking", "no"); // 关闭主机密钥检查

        System.out.println("Connected to " + hostname + " via SSH using key authentication.");
        return session;
    }
}
