package org.cyrilou.java_plugin_gradle.storage_alpha;

import org.cyrilou.java_plugin_gradle.spi.Plugin;
import org.cyrilou.java_plugin_gradle.spi.storage.StorageFactory;

import java.util.Arrays;

public class AlphaStoragePlugin implements Plugin {
    @Override
    public Iterable<StorageFactory> getStorageFactories()
    {
        return Arrays.asList(new AlphaStorageFactory());
    }
}
