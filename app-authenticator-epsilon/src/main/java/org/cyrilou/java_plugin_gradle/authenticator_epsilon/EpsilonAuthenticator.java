package org.cyrilou.java_plugin_gradle.authenticator_epsilon;

import org.cyrilou.java_plugin_gradle.spi.authenticator.Authenticator;

public class EpsilonAuthenticator implements Authenticator {
    @Override
    public void doAuthenticator() {
        System.out.println("I'm authenticating with the Epsilon Authenticator!");
    }
}
