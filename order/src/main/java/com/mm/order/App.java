package com.mm.order;

import io.reactivex.Single;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.config.ConfigRetriever;
import io.vertx.reactivex.core.Vertx;

public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    LOGGER.info("\n----------------------- \n Booting app\n-----------------------");
    final Vertx vertx = Vertx.vertx();

    // Read properties
    config(vertx).subscribe(json -> {
      // Deploy verticle
      vertx.rxDeployVerticle(new OrderVerticle(), new DeploymentOptions().setConfig(json))
        .subscribe(id -> LOGGER.info(String.format("Verticle with id {%s} deployed successfully", id)),
          err -> LOGGER.error("Error deploying verticle", err));
    });

  }

  private static Single<JsonObject> config(Vertx vertx) {
    final ConfigStoreOptions store = new ConfigStoreOptions()
      .setType("file")
      .setFormat("yaml")
      .setConfig(new JsonObject()
        .put("path", "config.yaml")
      );

    return ConfigRetriever.create(vertx, new ConfigRetrieverOptions().addStore(store)).rxGetConfig();

  }
}
