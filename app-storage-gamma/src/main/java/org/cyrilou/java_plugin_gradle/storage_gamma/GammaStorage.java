package org.cyrilou.java_plugin_gradle.storage_gamma;

import org.cyrilou.java_plugin_gradle.spi.storage.Storage;

public class GammaStorage implements Storage {
    @Override
    public void doStorage() {
        System.out.println("I'm storing in the Gamma Storage !");
    }
}
