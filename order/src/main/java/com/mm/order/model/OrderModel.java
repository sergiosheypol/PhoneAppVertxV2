package com.mm.order.model;

import java.util.UUID;

public final class OrderModel {
    private final UUID id;
    private final String customerName;
    private final String customerSurname;
    private final String customerEmail;
    private final UUID phoneId;

  public OrderModel(UUID id, String customerName, String customerSurname, String customerEmail, UUID phoneId) {
    this.id = id;
    this.customerName = customerName;
    this.customerSurname = customerSurname;
    this.customerEmail = customerEmail;
    this.phoneId = phoneId;
  }

  public static OrderModel.OrderModelBuilder builder() {
    return new OrderModelBuilder();
  }

  public UUID getId() {
    return this.id;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public String getCustomerSurname() {
    return this.customerSurname;
  }

  public String getCustomerEmail() {
    return this.customerEmail;
  }

  public UUID getPhoneId() {
    return this.phoneId;
  }

  public static class OrderModelBuilder {
    private UUID id;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private UUID phoneId;

    OrderModelBuilder() {
    }

    public OrderModel.OrderModelBuilder id(UUID id) {
      this.id = id;
      return this;
    }

    public OrderModel.OrderModelBuilder customerName(String customerName) {
      this.customerName = customerName;
      return this;
    }

    public OrderModel.OrderModelBuilder customerSurname(String customerSurname) {
      this.customerSurname = customerSurname;
      return this;
    }

    public OrderModelBuilder customerEmail(String customerEmail) {
      this.customerEmail = customerEmail;
      return this;
    }

    public OrderModel.OrderModelBuilder phoneId(UUID phoneId) {
      this.phoneId = phoneId;
      return this;
    }

    public OrderModel build() {
      return new OrderModel(id, customerName, customerSurname, customerEmail, phoneId);
    }
  }
}
