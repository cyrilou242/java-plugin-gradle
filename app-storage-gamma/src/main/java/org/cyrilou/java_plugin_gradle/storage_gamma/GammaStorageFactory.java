package org.cyrilou.java_plugin_gradle.storage_gamma;

import org.cyrilou.java_plugin_gradle.spi.storage.StorageFactory;

public class GammaStorageFactory implements StorageFactory {

    public String name() {
        return "storage-gamma";
    }

    public GammaStorage build() {
        return new GammaStorage();
    }
}
