package com.mm.catalog.application.getcatalog;

import com.mm.catalog.domain.model.PhoneModel;
import com.mm.catalog.domain.repository.CatalogRepository;
import io.reactivex.Flowable;

public class CatalogService {

  private final CatalogRepository repository;

  public CatalogService(final CatalogRepository repository) {
    this.repository = repository;
  }

  public Flowable<PhoneModel> getAll() {
    return this.repository.getAll();
  }
}
