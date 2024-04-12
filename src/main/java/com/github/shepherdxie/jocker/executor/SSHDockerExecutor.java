package com.github.shepherdxie.jocker.executor;

import com.github.shepherdxie.jocker.DockerCommand;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;

/**
 * @author Shepherd Xie
 * @since 2024/2/7
 */
public class SSHDockerExecutor implements DockerExecutor {

    @Override
    public String execute(DockerCommand dockerCommand) {

        return null;
    }
    public static void main(String[] args) {
        String sshHost = "remote-host"; // SSH 主机名或 IP 地址
        String sshUser = "username";    // SSH 用户名
        String sshPassword = "password"; // SSH 密码

        String dockerSockPath = "/var/run/docker.sock"; // Docker 守护进程的 UNIX 套接字路径

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(sshUser, sshHost, 22);
            session.setPassword(sshPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            // 创建 SSH 隧道，将本地端口转发到远程主机的 Docker 守护进程的 UNIX 套接字
            session.setPortForwardingL(9999, "localhost", 2375);

            // 创建 OkHttp 客户端，并将其配置为使用本地转发的端口
            OkHttpClient client = new OkHttpClient.Builder()
                    .socketFactory(new UnixDomainSocketFactory(new File("/var/run/docker.sock")))
                    .build();

            Request request = new Request.Builder()
                    .url("http://localhost:9999/_ping") // 使用本地转发的端口
                    .build();

            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println("Docker daemon is running.");
            } else {
                System.out.println("Failed to ping Docker daemon.");
            }

            // 关闭 SSH 会话
            session.disconnect();
        } catch (JSchException | IOException e) {
            e.printStackTrace();
        }
    }
}
