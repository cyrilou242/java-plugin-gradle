package org.cyrilou.java_plugin_gradle.authenticator_epsilon;

import org.cyrilou.java_plugin_gradle.spi.Plugin;
import org.cyrilou.java_plugin_gradle.spi.authenticator.AuthenticatorFactory;

import java.util.Arrays;

public class EpsilonAuthenticatorPlugin implements Plugin {
    @Override
    public Iterable<AuthenticatorFactory> getAuthenticatorFactories()
    {
        return Arrays.asList(new EpsilonAuthenticatorFactory());
    }
}
