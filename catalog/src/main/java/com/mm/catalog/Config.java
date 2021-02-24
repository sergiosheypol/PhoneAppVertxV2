package com.mm.catalog;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Config {

  private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
  private static Config instance = null;

  public JsonObject config;

  public static synchronized Config getInstance() {
    if(isNull(instance)) {
      instance = new Config();
    }
    return instance;
  }

  private Config() {

  }

  public void init(JsonObject configJson) {
    this.config = configJson;
    this.log();
  }

  private void log() {
    if(nonNull(config)) {
      LOGGER.info("Properties -- OK");
    } else {
      LOGGER.error("Unable to load properties");
    }
  }

  public Integer getPort() {
    return (Integer) this.getServerProperties().getValue("port");
  }

  private JsonObject getServerProperties() {
    return (JsonObject) config.getValue("server");
  }

}
