package com.mm.quarkus.catalog.repository.dummy;

import com.mm.quarkus.catalog.model.PhoneModel;
import com.mm.quarkus.catalog.repository.CatalogRepository;
import io.quarkus.arc.DefaultBean;
import io.reactivex.Flowable;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@DefaultBean
public class DummyCatalogRepository implements CatalogRepository {
  @Override
  public Flowable<PhoneModel> getAll() {
    return Flowable.just(PhoneData.getSamsung(),
      PhoneData.getIphone(),
      PhoneData.getXiaomi(),
      PhoneData.getHuawei());
  }
}
