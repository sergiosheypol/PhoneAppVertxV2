package com.mm.order.repository;

import com.mm.order.config.PostgresConfig;
import com.mm.order.model.OrderModel;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.sqlclient.Tuple;

import java.util.UUID;

public class PostgresOrderRepository implements OrderRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresOrderRepository.class);

  private final PostgresConfig postgres;

  public PostgresOrderRepository(PostgresConfig postgres) {
    this.postgres = postgres;
  }

  @Override
  public void save(final OrderModel model) {
    this.postgres.getPgClient()
      .preparedQuery(QueryGenerator.save())
      .rxExecute(this.generateTuple(model))
      .doOnSuccess(r -> LOGGER.info("Order saved successfully"))
      .subscribe();
  }

  private Tuple generateTuple(OrderModel model) {
    return Tuple.of(UUID.randomUUID(),
      model.getCustomerName(),
      model.getCustomerSurname(),
      model.getCustomerEmail(),
      model.getPhoneId());
  }
}
