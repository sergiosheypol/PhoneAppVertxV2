package com.mm.catalog.repository.postgres.mapper;

import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.model.PhonePriceModel;
import io.vertx.core.json.JsonObject;

import java.util.UUID;

public class PostgresCatalogMapper {
  public PhoneModel toModel(final JsonObject json) {
    return PhoneModel.builder()
      .id(UUID.fromString(json.getString("id")))
      .name(json.getString("name"))
      .description(json.getString("description"))
      .img(json.getString("img"))
      .price(PhonePriceModel.builder()
        .value(json.getDouble("price"))
        .currency(json.getString("currencyname"))
        .build())
      .build();
  }
}
