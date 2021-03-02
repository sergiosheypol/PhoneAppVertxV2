package com.mm.order.mapper;

import com.mm.order.handler.resource.OrderRQResource;
import com.mm.order.handler.resource.OrderRSResource;
import com.mm.order.model.OrderModel;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.sqlclient.Tuple;

import java.util.UUID;

public class OrderMapper {

  // TODO: handle nulls!!
  public OrderModel toModel(final OrderRQResource resource) {
    return OrderModel.builder()
      .id(UUID.randomUUID())
      .customerName(resource.getCustomerName())
      .customerSurname(resource.getCustomerSurname())
      .customerEmail(resource.getCustomerEmail())
      .phoneId(resource.getPhoneId())
      .build();
  }

  public OrderRSResource toResource(final UUID id) {
    return OrderRSResource.builder()
      .id(id)
      .build();
  }

  public Tuple toTuple(final OrderModel model) {
    return Tuple.of(UUID.randomUUID(),
      model.getCustomerName(),
      model.getCustomerSurname(),
      model.getCustomerEmail(),
      model.getPhoneId());
  }

  public JsonObject toJson(final OrderModel model) {
    JsonObject json = JsonObject.mapFrom(model).put("_id", model.getId().toString());
    json.remove("id");
    return json;
  }
}
