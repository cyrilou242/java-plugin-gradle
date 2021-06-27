package org.cyrilou.java_plugin_gradle.spi;

import org.cyrilou.java_plugin_gradle.spi.authenticator.AuthenticatorFactory;
import org.cyrilou.java_plugin_gradle.spi.storage.StorageFactory;

import java.util.Collections;

public interface Plugin {
    default Iterable<StorageFactory> getStorageFactories()
    {
        return Collections.emptyList();
    }

    default Iterable<AuthenticatorFactory> getAuthenticatorFactories()
    {
        return Collections.emptyList();
    }
}
