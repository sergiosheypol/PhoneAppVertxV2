package com.mm.catalog.infrastructure.persistence.postgres.config;

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
      .setPort(5432)
      .setHost("localhost")
      .setDatabase("mm")
      .setUser("mm")
      .setPassword("mm");
  }

  private PoolOptions getPoolOptions() {
    return new PoolOptions().setMaxSize(5);
  }
}
