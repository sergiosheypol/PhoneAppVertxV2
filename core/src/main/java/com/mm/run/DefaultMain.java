package com.mm.run;

import io.reactivex.Single;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.config.ConfigRetriever;
import io.vertx.reactivex.core.Vertx;

public abstract class DefaultMain {

  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMain.class);

  @SuppressWarnings("CheckReturnValue")
  public static void run(final Verticle v) {
    LOGGER.info("\n----------------------- \n Booting app\n-----------------------");

    // Read properties
    config(Vertx.vertx()).flatMap(json -> Vertx.currentContext().owner()
      .rxDeployVerticle(v, new DeploymentOptions().setConfig(json)))
      .subscribe(id -> LOGGER.info(String.format("Verticle with id {%s} deployed successfully", id)),
        err -> LOGGER.error("Error deploying verticle", err));
  }

  private static Single<JsonObject> config(final Vertx vertx) {
    final ConfigStoreOptions store = new ConfigStoreOptions()
      .setType("file")
      .setFormat("yaml")
      .setConfig(new JsonObject()
        .put("path", "config.yaml")
      );

    return ConfigRetriever.create(vertx, new ConfigRetrieverOptions().addStore(store)).rxGetConfig();

  }
}
