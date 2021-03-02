package com.mm.catalog.model;

public final class PhonePriceModel {
    private final String currency;
    private final Double value;

  public PhonePriceModel(String currency, Double value) {
    this.currency = currency;
    this.value = value;
  }

  public static PhonePriceModelBuilder builder() {
    return new PhonePriceModelBuilder();
  }

  public String getCurrency() {
    return this.currency;
  }

  public Double getValue() {
    return this.value;
  }

  public static class PhonePriceModelBuilder {
    private String currency;
    private Double value;

    PhonePriceModelBuilder() {
    }

    public PhonePriceModelBuilder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public PhonePriceModelBuilder value(Double value) {
      this.value = value;
      return this;
    }

    public PhonePriceModel build() {
      return new PhonePriceModel(currency, value);
    }
  }
}
