package com.mm.order.repository;

import com.mm.order.model.OrderModel;
import io.reactivex.Single;

import java.util.UUID;

public interface OrderRepository {
  Single<UUID> save(final OrderModel model);
}
