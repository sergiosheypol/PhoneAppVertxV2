package com.mm.order;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;

public final class Properties {

  public static Integer getPort() {
    return (Integer) getServerProperties().getValue("port");
  }

  public static String getDBHost() {
    return (String) getDBProperties().getValue("host");
  }

  public static Integer getDBPort() {
    return (Integer) getDBProperties().getValue("port");
  }

  public static String getDBName() {
    return (String) getDBProperties().getValue("name");
  }

  public static String getDBUser() {
    return (String) getDBProperties().getValue("user");
  }

  public static String getDBPassword() {
    return (String) getDBProperties().getValue("password");
  }

  private static JsonObject getServerProperties() {
    return (JsonObject) Vertx.currentContext().config().getValue("server");
  }

  private static JsonObject getDBProperties() {
    return (JsonObject) Vertx.currentContext().config().getValue("db");
  }

}
