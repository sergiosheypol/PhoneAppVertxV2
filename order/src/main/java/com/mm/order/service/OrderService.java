package com.mm.order.service;

import com.mm.order.model.OrderModel;
import com.mm.order.repository.OrderRepository;
import io.reactivex.Single;

import java.util.UUID;

public class OrderService {

  private final OrderRepository repository;

  public OrderService(OrderRepository repository) {
    this.repository = repository;
  }

  public Single<OrderModel> purchase() {

    final OrderModel model = OrderModel.builder()
      .customerEmail("a@a")
      .customerName("e")
      .customerSurname("e")
      .id(UUID.randomUUID())
      .phoneId(UUID.fromString("dda85294-7788-11eb-9439-0242ac130002"))
      .build();

    this.repository.save(model);

    return Single.just(model);
  }
}
