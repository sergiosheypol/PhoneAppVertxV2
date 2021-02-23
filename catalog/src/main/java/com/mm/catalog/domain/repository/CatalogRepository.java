package com.mm.catalog.domain.repository;

import com.mm.catalog.domain.model.PhoneModel;
import io.reactivex.Flowable;

public interface CatalogRepository {
  Flowable<PhoneModel> getAll();
}
