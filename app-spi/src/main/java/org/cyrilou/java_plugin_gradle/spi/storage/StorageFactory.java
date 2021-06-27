package org.cyrilou.java_plugin_gradle.spi.storage;

import org.cyrilou.java_plugin_gradle.spi.storage.Storage;

public interface StorageFactory {
    String name();
    Storage build();
}
