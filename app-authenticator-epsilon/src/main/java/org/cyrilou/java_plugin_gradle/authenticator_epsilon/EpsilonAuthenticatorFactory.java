package org.cyrilou.java_plugin_gradle.authenticator_epsilon;

import org.cyrilou.java_plugin_gradle.spi.authenticator.AuthenticatorFactory;

public class EpsilonAuthenticatorFactory implements AuthenticatorFactory {

    //the name used when calling the plugin
    public String name() {
        return "authenticator-epsilon";
    }

    public EpsilonAuthenticator build() {
        return new EpsilonAuthenticator();
    }
}
