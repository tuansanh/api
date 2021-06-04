package com.seveneleven.utilities;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class LoadConfig {

    private final Config config;
    public static final LoadConfig CONFIG = getInstance();

    private LoadConfig() {
        this.config = ConfigFactory.load("app.conf");
    }

    public String getProperty(String key) {
        String environment = System.getProperty("env");
        Config config = this.config.getConfig(environment);
        return config.getString(key);
    }

    public static LoadConfig getInstance() {
        return new LoadConfig();
    }

}
