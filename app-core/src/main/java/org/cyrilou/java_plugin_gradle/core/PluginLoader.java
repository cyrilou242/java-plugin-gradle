package org.cyrilou.java_plugin_gradle.core;

import org.cyrilou.java_plugin_gradle.spi.Plugin;
import org.cyrilou.java_plugin_gradle.spi.authenticator.AuthenticatorFactory;
import org.cyrilou.java_plugin_gradle.spi.storage.Storage;
import org.cyrilou.java_plugin_gradle.spi.storage.StorageFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.Objects.requireNonNull;

public class PluginLoader {
    private final Map<String, StorageFactory> storageFactoryMap = new HashMap<>();
    private final Map<String, AuthenticatorFactory> authenticatorFactoryMap = new HashMap<>();
    private final File pluginsDir;
    private final AtomicBoolean loading =  new AtomicBoolean();

    public PluginLoader(final File pluginsDir) {
        this.pluginsDir = pluginsDir;
    }
    
    public void loadPlugins() {
        if (!pluginsDir.exists() || !pluginsDir.isDirectory()) {
            System.err.println("Skipping Plugin Loading. Plugin dir not found: " + pluginsDir);
            return;
        }
        
        if (loading.compareAndSet(false, true)) {
            final File[]  files = requireNonNull(pluginsDir.listFiles());
            for (File pluginDir: files) {
                if (pluginDir.isDirectory()) {
                    loadPlugin(pluginDir);
                }
            }
        }
    }

    private void loadPlugin(final File pluginDir) {
        System.out.println("Loading plugin: " + pluginDir);
        final URLClassLoader pluginClassLoader = createPluginClassLoader(pluginDir);
        final ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(pluginClassLoader);
            ServiceLoader.load(Plugin.class, pluginClassLoader).forEach(this::installPlugin);
        } finally {
            Thread.currentThread().setContextClassLoader(currentClassLoader);
        }
    }

    private void installPlugin(Plugin plugin) {
        System.out.println("Installing plugin: " + plugin.getClass().getName());
        for (StorageFactory factory : plugin.getStorageFactories()) {
            System.out.println("Putting storage plugin: " + factory.name() );
            storageFactoryMap.put(factory.name(), factory);
        }
        for (AuthenticatorFactory factory : plugin.getAuthenticatorFactories()) {
            authenticatorFactoryMap.put(factory.name(), factory);
        }

    }

    private URLClassLoader createPluginClassLoader(File dir) {
        final URL[] urls = Arrays.stream(Optional.ofNullable(dir.listFiles()).orElse(new File[]{}))
                .sorted()
                .map(File::toURI)
                .map(this::toUrl)
                .toArray(URL[]::new);

        return new PluginClassLoader(urls, getClass().getClassLoader());
    }

    private URL toUrl(final URI uri) {
        try {
            return uri.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public StorageFactory getStorageFactory(String name) {
        return storageFactoryMap.get(name);
    }

    public AuthenticatorFactory getAuthenticatorFactory(String name) {
        return authenticatorFactoryMap.get(name);
    }
}
