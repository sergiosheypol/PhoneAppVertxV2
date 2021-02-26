package com.mm.order.service;

import com.mm.order.model.OrderModel;
import io.reactivex.Single;

import java.util.UUID;

public class OrderService {
  public Single<OrderModel> purchase() {
    return Single.just(OrderModel.builder()
      .customerEmail("a@a")
      .customerName("e")
      .id(UUID.randomUUID())
      .build());
  }
}
