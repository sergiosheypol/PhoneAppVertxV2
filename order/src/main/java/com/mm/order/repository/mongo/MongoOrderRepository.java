package com.mm.order.repository.mongo;

import com.mm.mongo.MongoConfig;
import com.mm.order.mapper.OrderMapper;
import com.mm.order.model.OrderModel;
import com.mm.order.repository.OrderRepository;
import io.reactivex.Single;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

import java.util.UUID;

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
  public Single<UUID> save(final OrderModel model) {
    return mongoConfig.getMongoClient()
      .rxInsert(ORDER_COLLECTION, this.mapper.toJson(model))
      .doOnComplete(() -> LOGGER.info("Item saved successfully"))
      .doOnError(t -> LOGGER.error(String.format("Error saving object: %s", t.getMessage())))
      .toSingle(model.getId().toString())
      .map(UUID::fromString);
  }
}
