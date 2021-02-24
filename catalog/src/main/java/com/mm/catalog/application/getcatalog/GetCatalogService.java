package com.mm.catalog.application.getcatalog;

import com.mm.catalog.domain.model.PhoneModel;
import com.mm.catalog.domain.repository.CatalogRepository;
import com.mm.catalog.infrastructure.persistence.DummyCatalogRepository;
import io.reactivex.Flowable;

public class GetCatalogService {

  private final CatalogRepository repository;

  public GetCatalogService() {
    this.repository = new DummyCatalogRepository();
  }

  public Flowable<PhoneModel> getAll() {
    return this.repository.getAll();
  }
}
