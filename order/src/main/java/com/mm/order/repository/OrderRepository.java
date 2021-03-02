package com.mm.order.repository;

import com.mm.order.model.OrderModel;

public interface OrderRepository {
  void save(final OrderModel model);
}
