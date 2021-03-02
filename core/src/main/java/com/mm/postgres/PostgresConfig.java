package com.mm.postgres;

import com.mm.properties.ConfigProperties;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;

public class PostgresConfig {

  private final PgPool pgClient;

  public PostgresConfig() {
    this.pgClient = PgPool.pool(Vertx.currentContext().owner(), this.getConnectOptions(), this.getPoolOptions());
  }

  public PgPool getPgClient() {
    return pgClient;
  }

  private PgConnectOptions getConnectOptions() {
    return new PgConnectOptions()
      .setPort(ConfigProperties.getPGPort())
      .setHost(ConfigProperties.getPGHost())
      .setDatabase(ConfigProperties.getPGName())
      .setUser(ConfigProperties.getPGUser())
      .setPassword(ConfigProperties.getPGPassword());
  }

  private PoolOptions getPoolOptions() {
    return new PoolOptions().setMaxSize(5);
  }
}
