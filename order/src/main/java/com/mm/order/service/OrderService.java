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

  public Single<UUID> purchase(final OrderModel model) {
    return this.repository.save(model);
  }
}
