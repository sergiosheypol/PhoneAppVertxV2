package com.mm.quarkus.catalog.handler.resource;

public class PhonePriceResource {
  private final String currency;
  private final Double value;

  public PhonePriceResource(String currency, Double value) {
    this.currency = currency;
    this.value = value;
  }

  public static PhonePriceResourceBuilder builder() {
    return new PhonePriceResourceBuilder();
  }

  public String getCurrency() {
    return this.currency;
  }

  public Double getValue() {
    return this.value;
  }

  public static class PhonePriceResourceBuilder {
    private String currency;
    private Double value;

    PhonePriceResourceBuilder() {
    }

    public PhonePriceResourceBuilder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public PhonePriceResourceBuilder value(Double value) {
      this.value = value;
      return this;
    }

    public PhonePriceResource build() {
      return new PhonePriceResource(currency, value);
    }
  }
}
