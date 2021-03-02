package com.mm.order.mapper;

import com.mm.order.handler.resource.OrderRQResource;
import com.mm.order.handler.resource.OrderRSResource;
import com.mm.order.model.OrderModel;

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

  public OrderRSResource toResource(final OrderModel model) {
    return OrderRSResource.builder()
      .id(model.getId())
      .build();
  }
}
