package com.mm.catalog.repository;

import com.mm.catalog.model.PhoneModel;
import io.reactivex.Flowable;

public interface CatalogRepository {
  Flowable<PhoneModel> getAll();
}
