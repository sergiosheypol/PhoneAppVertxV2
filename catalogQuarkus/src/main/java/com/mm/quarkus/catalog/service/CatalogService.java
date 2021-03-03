package com.mm.quarkus.catalog.service;

import com.mm.quarkus.catalog.model.PhoneModel;
import com.mm.quarkus.catalog.repository.CatalogRepository;
import io.reactivex.Flowable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CatalogService {

  @Inject
  CatalogRepository repository;

  public Flowable<PhoneModel> getAll() {
    return this.repository.getAll();
  }
}
