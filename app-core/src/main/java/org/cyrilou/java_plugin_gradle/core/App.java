package org.cyrilou.java_plugin_gradle.core;

import org.cyrilou.java_plugin_gradle.spi.authenticator.Authenticator;
import org.cyrilou.java_plugin_gradle.spi.authenticator.AuthenticatorFactory;
import org.cyrilou.java_plugin_gradle.spi.storage.Storage;
import org.cyrilou.java_plugin_gradle.spi.storage.StorageFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[]  args) {
        new App().run(args);
    }

    private void run(String[] args) {
        System.out.println("Starting the core app;");

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);

        String pluginsPath = "build" + File.separatorChar + "plugins";
        if (args.length > 0) {
            pluginsPath = args[0];
        }

        PluginLoader pluginLoader = new PluginLoader(new File(pluginsPath));
        pluginLoader.loadPlugins();

        StorageFactory storageFactory = pluginLoader.getStorageFactory("storage-alpha");
        if (storageFactory == null) {
            System.err.println("No Storage factories loaded!");
            return;
        }

        System.out.println("this is running from the storage plugin: ");
        final Storage storage = storageFactory.build();
        storage.doStorage();

        AuthenticatorFactory authenticatorFactory = pluginLoader.getAuthenticatorFactory("authenticator-epsilon");
        if (authenticatorFactory == null) {
            System.err.println("No Authenticator factories loaded!");
            return;
        }
        System.out.println("this is running from the authenticator plugin: ");
        final Authenticator authenticator = authenticatorFactory.build();
        authenticator.doAuthenticator();

    }
}
