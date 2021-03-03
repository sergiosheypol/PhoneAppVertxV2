package com.mm.quarkus.catalog.repository;

import com.mm.quarkus.catalog.model.PhoneModel;
import io.reactivex.Flowable;

public interface CatalogRepository {
  Flowable<PhoneModel> getAll();
}
