package com.mm.quarkus.catalog.mapper;

import com.mm.quarkus.catalog.handler.resource.PhonePriceResource;
import com.mm.quarkus.catalog.handler.resource.PhoneResource;
import com.mm.quarkus.catalog.model.PhoneModel;
import com.mm.quarkus.catalog.model.PhonePriceModel;
import io.vertx.mutiny.sqlclient.Row;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;


@ApplicationScoped
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

  public PhoneModel toModel(final Row row) {
    return PhoneModel.builder()
      .id(row.getUUID("id"))
      .name(row.getString("name"))
      .description(row.getString("description"))
      .img(row.getString("img"))
      .price(PhonePriceModel.builder()
        .value(row.getDouble("price"))
        .currency(row.getString("currencyname"))
        .build())
      .build();
  }

  public PhoneModel toModel(final Document doc) {
    return PhoneModel.builder()
      .id(UUID.fromString(doc.getString("_id")))
      .name(doc.getString("name"))
      .description(doc.getString("description"))
      .img(doc.getString("img"))
      .price(PhonePriceModel.builder()
        .currency(((Document) doc.get("price")).getString("currency"))
        .value(((Document) doc.get("price")).getDouble("value"))
        .build())
      .build();
  }

}
