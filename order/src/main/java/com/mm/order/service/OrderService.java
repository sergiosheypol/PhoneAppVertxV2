package com.mm.order.service;

import com.mm.order.model.OrderModel;
import com.mm.order.repository.OrderRepository;
import io.reactivex.Single;

public class OrderService {

  private final OrderRepository repository;

  public OrderService(OrderRepository repository) {
    this.repository = repository;
  }

  public Single<OrderModel> purchase(final OrderModel model) {

    this.repository.save(model);
    return Single.just(model);
  }
}
