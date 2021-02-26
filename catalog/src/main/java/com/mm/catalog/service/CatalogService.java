package com.mm.catalog.service;

import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.repository.CatalogRepository;
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
