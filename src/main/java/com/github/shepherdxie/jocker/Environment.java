package com.github.shepherdxie.jocker;

import com.jcraft.jsch.Session;
import lombok.Data;

/**
 * @author Shepherd Xie
 * @since 2024/4/17
 */
@Data
public class Environment {
    public static final Environment DEFAULT = new Environment(Protocol.UNIX_SOCKET, "/var/run/docker.sock");
    private Protocol protocol;
    private String host;
    private Session session;

    private Environment() {

    }

    private Environment(Protocol protocol, String host) {
        this.protocol = protocol;
        this.host = host;
    }

    private Environment(Protocol protocol, String host, Session session) {
        this.protocol = protocol;
        this.host = host;
        this.session = session;
    }

    public static Environment from(Protocol protocol, String host) {
        return new Environment(protocol, host);
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Protocol protocol;
        private String host;
        private Session session;

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder viaSsh(Session session) {
            this.session = session;
            return this;
        }

        public Environment build() {
            return new Environment(protocol, host, session);
        }
    }

    public enum Protocol {
        UNIX_SOCKET_VIA_SSH(""),
        UNIX_SOCKET("unix://"),
        HTTP("http://"),
        HTTPS("https://");

        private String value;

        Protocol(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
