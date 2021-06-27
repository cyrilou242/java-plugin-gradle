package org.cyrilou.java_plugin_gradle.storage_alpha;

import org.cyrilou.java_plugin_gradle.spi.storage.StorageFactory;

public class AlphaStorageFactory implements StorageFactory {

    //the name used when calling the plugin
    public String name() {
        return "storage-alpha";
    }

    public AlphaStorage build() {
        return new AlphaStorage();
    }
}
