package com.mm.catalog.infrastructure.handler.mapper;

import com.mm.catalog.domain.model.PhoneModel;
import com.mm.catalog.infrastructure.handler.resource.PhonePriceResource;
import com.mm.catalog.infrastructure.handler.resource.PhoneResource;

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
