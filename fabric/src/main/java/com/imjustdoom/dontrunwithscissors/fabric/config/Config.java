package com.imjustdoom.dontrunwithscissors.fabric.config;

public class Config {

    SimpleConfig CONFIG = SimpleConfig.of("config").provider(this::provider).request();

    private String provider(String filename) {
        return "#My default config content\n";
    }

    // And that's it! Now you can request values from the config:
    public final String SOME_STRING = CONFIG.getOrDefault("key.of.the.value1", "default value");
    public final int SOME_INTEGER = CONFIG.getOrDefault("key.of.the.value2", 42);
    public final boolean SOME_BOOL = CONFIG.getOrDefault("key.of.the.value3", false);
}
