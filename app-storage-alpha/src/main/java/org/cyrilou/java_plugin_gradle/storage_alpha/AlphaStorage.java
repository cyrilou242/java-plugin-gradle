package org.cyrilou.java_plugin_gradle.storage_alpha;

import org.cyrilou.java_plugin_gradle.spi.storage.Storage;

public class AlphaStorage implements Storage {
    @Override
    public void doStorage() {
        System.out.println("I'm storing in the Alpha Storage !");
    }
}
