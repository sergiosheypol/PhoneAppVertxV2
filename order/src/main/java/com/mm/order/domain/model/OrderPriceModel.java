package com.mm.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public final class OrderPriceModel {
    private final String currency;
    private final Double value;
}
