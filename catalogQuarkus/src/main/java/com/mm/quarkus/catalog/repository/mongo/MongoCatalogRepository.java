package com.mm.quarkus.catalog.repository.mongo;

import com.mm.quarkus.catalog.mapper.PhoneMapper;
import com.mm.quarkus.catalog.model.PhoneModel;
import com.mm.quarkus.catalog.repository.CatalogRepository;
import io.quarkus.arc.properties.IfBuildProperty;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.reactivex.Flowable;
import io.smallrye.mutiny.converters.multi.MultiRxConverters;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@IfBuildProperty(name = "repository", stringValue = "mongo")
public class MongoCatalogRepository implements CatalogRepository {

  public static final String CATALOG_COLLECTION = "catalog";
  public static final String MM_DB = "mm";

  @Inject
  ReactiveMongoClient client;

  @Inject
  PhoneMapper mapper;

  @Override
  public Flowable<PhoneModel> getAll() {
    return client
      .getDatabase(MM_DB)
      .getCollection(CATALOG_COLLECTION)
      .find()
      .map(mapper::toModel)
      .convert().with(MultiRxConverters.toFlowable());

  }
}
