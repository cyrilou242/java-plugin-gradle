package org.cyrilou.java_plugin_gradle.spi.authenticator;

public interface AuthenticatorFactory {
    String name();
    Authenticator build();
}
