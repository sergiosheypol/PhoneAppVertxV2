package com.mm.order;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Properties {

  private static final Logger LOGGER = LoggerFactory.getLogger(Properties.class);
  private static Properties instance = null;

  public JsonObject config;

  public static synchronized Properties getInstance() {
    if(isNull(instance)) {
      instance = new Properties();
    }
    return instance;
  }

  private Properties() {

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

  public String getDBHost() {
    return (String) this.getDBProperties().getValue("host");
  }

  public Integer getDBPort() {
    return (Integer) this.getDBProperties().getValue("port");
  }

  public String getDBName() {
    return (String) this.getDBProperties().getValue("name");
  }

  public String getDBUser() {
    return (String) this.getDBProperties().getValue("user");
  }

  public String getDBPassword() {
    return (String) this.getDBProperties().getValue("password");
  }

  private JsonObject getServerProperties() {
    return (JsonObject) config.getValue("server");
  }

  private JsonObject getDBProperties() {
    return (JsonObject) config.getValue("db");
  }
}
