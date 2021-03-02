package com.mm.order.repository.mongo;

import com.mm.mongo.MongoConfig;
import com.mm.order.mapper.OrderMapper;
import com.mm.order.model.OrderModel;
import com.mm.order.repository.OrderRepository;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class MongoOrderRepository implements OrderRepository {

  public static final String ORDER_COLLECTION = "order";
  private static final Logger LOGGER = LoggerFactory.getLogger(MongoOrderRepository.class);

  private final MongoConfig mongoConfig;
  private final OrderMapper mapper;

  public MongoOrderRepository(final MongoConfig mongoConfig, final OrderMapper mapper) {
    this.mongoConfig = mongoConfig;
    this.mapper = mapper;
  }


  @Override
  public void save(final OrderModel model) {
    mongoConfig.getMongoClient()
      .rxInsert(ORDER_COLLECTION, this.mapper.toJson(model))
      .doOnSuccess(r -> LOGGER.info(String.format("Saved successfully %s", r)))
      .subscribe();
  }
}
