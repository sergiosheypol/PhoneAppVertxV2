package com.mm.catalog.infrastructure.persistence;

import com.mm.catalog.domain.model.PhoneModel;
import com.mm.catalog.domain.repository.CatalogRepository;
import io.reactivex.Flowable;

public class DummyCatalogRepository implements CatalogRepository {
  @Override
  public Flowable<PhoneModel> getAll() {
    return null;
  }
}
