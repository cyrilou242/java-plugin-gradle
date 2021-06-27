package org.cyrilou.java_plugin_gradle.storage_gamma;

import org.cyrilou.java_plugin_gradle.spi.Plugin;
import org.cyrilou.java_plugin_gradle.spi.storage.StorageFactory;

import java.util.Arrays;

public class GammaStoragePlugin implements Plugin {
    @Override
    public Iterable<StorageFactory> getStorageFactories()
    {
        return Arrays.asList(new GammaStorageFactory());
    }
}
