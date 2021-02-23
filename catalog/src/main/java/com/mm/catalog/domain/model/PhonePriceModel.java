package com.mm.catalog.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public final class PhonePriceModel {
    private final String currency;
    private final Double value;
}
