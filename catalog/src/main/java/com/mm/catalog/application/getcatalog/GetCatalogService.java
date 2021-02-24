package com.mm.catalog.application.getcatalog;

import com.mm.catalog.IoC;
import com.mm.catalog.domain.model.PhoneModel;
import io.reactivex.Flowable;

public class GetCatalogService {

  public Flowable<PhoneModel> getAll() {
    return IoC.getInstance().repository.getAll();
  }
}
