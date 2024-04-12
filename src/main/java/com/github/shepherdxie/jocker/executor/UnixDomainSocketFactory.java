package com.github.shepherdxie.jocker.executor;

import jnr.unixsocket.UnixSocketChannel;

import javax.net.SocketFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Shepherd Xie
 * @since 2024/4/12
 */
public final class UnixDomainSocketFactory extends SocketFactory {
    private final File path;

    public UnixDomainSocketFactory(File path) {
        this.path = path;
    }

    @Override
    public Socket createSocket() throws IOException {
        UnixSocketChannel channel = UnixSocketChannel.open();
        return new TunnelingUnixSocket(path, channel);
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        Socket result = createSocket();

        try {
            result.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            result.close();
            throw e;
        }
        return result;
    }

    @Override
    public Socket createSocket(
            String host, int port, InetAddress localHost, int localPort) throws IOException {
        return createSocket(host, port);
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Socket result = createSocket();

        try {
            result.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            result.close();
            throw e;
        }
        return result;
    }

    @Override
    public Socket createSocket(
            InetAddress host, int port, InetAddress localAddress, int localPort) throws IOException {
        return createSocket(host, port);
    }
}