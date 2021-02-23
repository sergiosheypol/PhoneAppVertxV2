package com.mm.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public final class OrderModel {
    private final UUID id;
    private final String customerName;
    private final String customerSurname;
    private final String customerEmail;
    private final OrderPriceModel price;
}
