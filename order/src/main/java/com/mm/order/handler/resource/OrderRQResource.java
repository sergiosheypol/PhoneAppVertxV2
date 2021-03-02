package com.mm.order.handler.resource;

import java.util.UUID;

public class OrderRQResource {
  private String customerName;
  private String customerSurname;
  private String customerEmail;
  private UUID phoneId;

  public OrderRQResource(String customerName, String customerSurname, String customerEmail, UUID phoneId) {
    this.customerName = customerName;
    this.customerSurname = customerSurname;
    this.customerEmail = customerEmail;
    this.phoneId = phoneId;
  }

  public OrderRQResource() {
  }

  public static OrderResourceBuilder builder() {
    return new OrderResourceBuilder();
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

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setCustomerSurname(String customerSurname) {
    this.customerSurname = customerSurname;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public void setPhoneId(UUID phoneId) {
    this.phoneId = phoneId;
  }

  public static class OrderResourceBuilder {
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private UUID phoneId;

    OrderResourceBuilder() {
    }

    public OrderResourceBuilder customerName(String customerName) {
      this.customerName = customerName;
      return this;
    }

    public OrderResourceBuilder customerSurname(String customerSurname) {
      this.customerSurname = customerSurname;
      return this;
    }

    public OrderResourceBuilder customerEmail(String customerEmail) {
      this.customerEmail = customerEmail;
      return this;
    }

    public OrderResourceBuilder phoneId(UUID phoneId) {
      this.phoneId = phoneId;
      return this;
    }

    public OrderRQResource build() {
      return new OrderRQResource(customerName, customerSurname, customerEmail, phoneId);
    }
  }
}
