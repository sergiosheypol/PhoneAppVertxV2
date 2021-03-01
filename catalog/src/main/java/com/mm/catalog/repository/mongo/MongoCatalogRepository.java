package com.mm.catalog.repository.mongo;

import com.mm.catalog.mapper.PhoneMapper;
import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.repository.CatalogRepository;
import com.mm.mongo.MongoConfig;
import io.reactivex.Flowable;
import io.vertx.core.json.JsonObject;

public class MongoCatalogRepository implements CatalogRepository {

  private final MongoConfig mongoConfig;
  private final PhoneMapper mapper;

  public MongoCatalogRepository(final MongoConfig mongoConfig, final PhoneMapper mapper) {
    this.mongoConfig = mongoConfig;
    this.mapper = mapper;
  }

  @Override
  public Flowable<PhoneModel> getAll() {
    return mongoConfig.getMongoClient()
      .findBatch("catalog", new JsonObject())
      .toFlowable()
      .map(mapper::toModelFromMongo);
  }
}
