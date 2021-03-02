package com.mm.order.repository.postgres;

import com.mm.order.model.OrderModel;
import com.mm.order.repository.OrderRepository;
import com.mm.postgres.PostgresConfig;
import com.mm.postgres.QueryGenerator;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.sqlclient.Tuple;

import java.util.UUID;

public class PostgresOrderRepository implements OrderRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostgresOrderRepository.class);

  private final PostgresConfig postgres;

  public PostgresOrderRepository(final PostgresConfig postgres) {
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
