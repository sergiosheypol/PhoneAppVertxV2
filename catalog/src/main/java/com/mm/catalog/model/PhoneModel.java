package com.mm.catalog.model;

import java.util.UUID;

public final class PhoneModel {
    private final UUID id;
    private final String name;
    private final String img;
    private final String description;
    private final PhonePriceModel price;

  public PhoneModel(UUID id, String name, String img, String description, PhonePriceModel price) {
    this.id = id;
    this.name = name;
    this.img = img;
    this.description = description;
    this.price = price;
  }

  public static PhoneModelBuilder builder() {
    return new PhoneModelBuilder();
  }

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getImg() {
    return this.img;
  }

  public String getDescription() {
    return this.description;
  }

  public PhonePriceModel getPrice() {
    return this.price;
  }

  public static class PhoneModelBuilder {
    private UUID id;
    private String name;
    private String img;
    private String description;
    private PhonePriceModel price;

    PhoneModelBuilder() {
    }

    public PhoneModelBuilder id(UUID id) {
      this.id = id;
      return this;
    }

    public PhoneModelBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PhoneModelBuilder img(String img) {
      this.img = img;
      return this;
    }

    public PhoneModelBuilder description(String description) {
      this.description = description;
      return this;
    }

    public PhoneModelBuilder price(PhonePriceModel price) {
      this.price = price;
      return this;
    }

    public PhoneModel build() {
      return new PhoneModel(id, name, img, description, price);
    }
  }
}
