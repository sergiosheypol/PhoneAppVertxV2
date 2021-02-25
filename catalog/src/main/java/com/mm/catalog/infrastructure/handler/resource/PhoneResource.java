package com.mm.catalog.infrastructure.handler.resource;

import java.util.UUID;

public class PhoneResource {
  private UUID id;
  private final String name;
  private final String img;
  private final String description;
  private final PhonePriceResource price;

  public PhoneResource(UUID id, String name, String img, String description, PhonePriceResource price) {
    this.id = id;
    this.name = name;
    this.img = img;
    this.description = description;
    this.price = price;
  }

  public static PhoneResourceBuilder builder() {
    return new PhoneResourceBuilder();
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

  public PhonePriceResource getPrice() {
    return this.price;
  }

  public static class PhoneResourceBuilder {
    private UUID id;
    private String name;
    private String img;
    private String description;
    private PhonePriceResource price;

    PhoneResourceBuilder() {
    }

    public PhoneResourceBuilder id(UUID id) {
      this.id = id;
      return this;
    }

    public PhoneResourceBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PhoneResourceBuilder img(String img) {
      this.img = img;
      return this;
    }

    public PhoneResourceBuilder description(String description) {
      this.description = description;
      return this;
    }

    public PhoneResourceBuilder price(PhonePriceResource price) {
      this.price = price;
      return this;
    }

    public PhoneResource build() {
      return new PhoneResource(id, name, img, description, price);
    }
  }
}
