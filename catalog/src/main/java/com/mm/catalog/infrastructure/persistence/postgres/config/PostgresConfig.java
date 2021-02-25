package com.mm.catalog.infrastructure.persistence.postgres.config;

import io.vertx.pgclient.PgConnectOptions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;

public final class PostgresConfig {
  public static PgPool init() {
    // Connect options
    PgConnectOptions connectOptions = new PgConnectOptions()
      .setPort(5432)
      .setHost("localhost")
      .setDatabase("mm")
      .setUser("mm")
      .setPassword("mm");

    // Pool options
    PoolOptions poolOptions = new PoolOptions().setMaxSize(5);

    // Create the client pool
    return PgPool.pool(Vertx.currentContext().owner(), connectOptions, poolOptions);
  }
}
