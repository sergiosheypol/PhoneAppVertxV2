package com.mm.order.repository.postgres;

import com.mm.order.mapper.OrderMapper;
import com.mm.order.model.OrderModel;
import com.mm.order.repository.OrderRepository;
import com.mm.postgres.PostgresConfig;
import com.mm.postgres.QueryGenerator;
import io.reactivex.Single;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

import java.util.UUID;

public class PostgresOrderRepository implements OrderRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresOrderRepository.class);

  private final PostgresConfig postgres;
  private final OrderMapper mapper;

  public PostgresOrderRepository(final PostgresConfig postgres, final OrderMapper mapper) {
    this.postgres = postgres;
    this.mapper = mapper;
  }

  @Override
  public Single<UUID> save(final OrderModel model) {
    return this.postgres.getPgClient()
      .preparedQuery(QueryGenerator.save())
      .rxExecute(this.mapper.toTuple(model))
      .doOnSuccess(r -> LOGGER.info("Order saved successfully"))
      .doOnError(t -> LOGGER.error("Error saving item", t))
      .map(__ -> model.getId());
  }
}
