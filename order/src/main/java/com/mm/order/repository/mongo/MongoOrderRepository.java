package com.mm.order.repository.mongo;

import com.mm.mongo.MongoConfig;
import com.mm.order.model.OrderModel;
import com.mm.order.repository.OrderRepository;

public class MongoOrderRepository implements OrderRepository {

  private final MongoConfig mongoConfig;

  public MongoOrderRepository(final MongoConfig mongoConfig) {
    this.mongoConfig = mongoConfig;
  }


  @Override
  public void save(OrderModel model) {

  }
}
