package com.mm.catalog.handler.mapper;

import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.handler.resource.PhonePriceResource;
import com.mm.catalog.handler.resource.PhoneResource;

public class PhoneResourceMapper {
  public PhoneResource toResource(final PhoneModel model) {
    return PhoneResource.builder()
      .id(model.getId())
      .description(model.getDescription())
      .img(model.getImg())
      .name(model.getName())
      .price(PhonePriceResource.builder()
        .currency(model.getPrice().getCurrency())
        .value(model.getPrice().getValue())
        .build())
      .build();
  }
}
