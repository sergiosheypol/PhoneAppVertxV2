package com.mm.order.handler.resource;

import java.util.UUID;

public class OrderRSResource {
  private final UUID id;

  public OrderRSResource(UUID id) {
    this.id = id;
  }

  public static OrderRSResourceBuilder builder() {
    return new OrderRSResourceBuilder();
  }

  public UUID getId() {
    return this.id;
  }

  public static class OrderRSResourceBuilder {
    private UUID id;

    OrderRSResourceBuilder() {
    }

    public OrderRSResourceBuilder id(UUID id) {
      this.id = id;
      return this;
    }

    public OrderRSResource build() {
      return new OrderRSResource(id);
    }
  }
}
