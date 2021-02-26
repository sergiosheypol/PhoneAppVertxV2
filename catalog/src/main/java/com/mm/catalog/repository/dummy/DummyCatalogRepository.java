package com.mm.catalog.repository.dummy;

import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.repository.CatalogRepository;
import io.reactivex.Flowable;

public class DummyCatalogRepository implements CatalogRepository {
  @Override
  public Flowable<PhoneModel> getAll() {
    return Flowable.just(PhoneData.getSamsung(),
      PhoneData.getIphone(),
      PhoneData.getXiaomi(),
      PhoneData.getHuawei());
  }
}
