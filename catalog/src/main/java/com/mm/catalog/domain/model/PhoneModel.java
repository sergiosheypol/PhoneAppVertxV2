package com.mm.catalog.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public final class PhoneModel {
    private final Long id;
    private final String name;
    private final String img;
    private final String description;
    private final PhonePriceModel price;
}
