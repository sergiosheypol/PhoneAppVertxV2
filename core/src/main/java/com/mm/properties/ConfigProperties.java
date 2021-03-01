package com.mm.properties;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;

import java.util.Optional;

public final class ConfigProperties {

  public static Boolean isDummyEnabled() {
    return Optional.ofNullable((Boolean) Vertx.currentContext().config().getValue("dummy"))
      .orElse(Boolean.TRUE);
  }

  public static Integer getPort() {
    return (Integer) getServerProperties().getValue("port");
  }

  public static String getPGHost() {
    return (String) getPGProperties().getValue("host");
  }

  public static Integer getPGPort() {
    return (Integer) getPGProperties().getValue("port");
  }

  public static String getPGName() {
    return (String) getPGProperties().getValue("name");
  }

  public static String getPGUser() {
    return (String) getPGProperties().getValue("user");
  }

  public static String getPGPassword() {
    return (String) getPGProperties().getValue("password");
  }

  private static JsonObject getServerProperties() {
    return (JsonObject) Vertx.currentContext().config().getValue("server");
  }

  private static JsonObject getPGProperties() {
    return (JsonObject) Vertx.currentContext().config().getValue("postgres");
  }

  public static JsonObject getMongoProperties() {
    return (JsonObject) Vertx.currentContext().config().getValue("mongo");
  }

}
