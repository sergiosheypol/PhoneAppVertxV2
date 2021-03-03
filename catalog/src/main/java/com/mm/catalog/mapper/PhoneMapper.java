package com.mm.catalog.mapper;

import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.model.PhonePriceModel;
import com.mm.catalog.handler.resource.PhonePriceResource;
import com.mm.catalog.handler.resource.PhoneResource;
import io.vertx.core.json.JsonObject;

import java.util.UUID;

public class PhoneMapper {
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

  public PhoneModel toModelFromMongo(final JsonObject json) {
    return PhoneModel.builder()
      .id(UUID.fromString(json.getString("_id")))
      .name(json.getString("name"))
      .description(json.getString("description"))
      .img(json.getString("img"))
      .price(PhonePriceModel.builder()
        .value(json.getJsonObject("price").getDouble("value"))
        .currency(json.getJsonObject("price").getString("currency"))
        .build())
      .build();
  }
}
