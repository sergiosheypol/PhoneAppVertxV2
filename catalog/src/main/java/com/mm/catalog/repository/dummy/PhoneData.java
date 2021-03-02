package com.mm.catalog.repository.dummy;

import com.mm.catalog.model.PhoneModel;
import com.mm.catalog.model.PhonePriceModel;

import java.util.UUID;

public final class PhoneData {

    public static final String EURO_CURRENCY = "euro";

    public static PhoneModel getIphone() {
        return PhoneModel.builder()
                .id(UUID.randomUUID())
                .img("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-xr-og-201809?wid=1200&hei=630&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1535560276044")
                .name("iPhone")
                .description("Apple iPhone 12")
                .price(PhonePriceModel.builder()
                        .currency(EURO_CURRENCY)
                        .value(999.99)
                        .build())
                .build();
    }

    public static PhoneModel getSamsung() {
        return PhoneModel.builder()
                .id(UUID.randomUUID())
                .img("https://imagenes.milenio.com/YKeE7McwvNTvSD14u1Tb-QGZsFE=/958x596/https://www.milenio.com/uploads/media/2021/01/14/samsung-galaxy-s-1.png")
                .name("S21")
                .description("Samsung Galaxy S21")
                .price(PhonePriceModel.builder()
                        .currency(EURO_CURRENCY)
                        .value(988.00)
                        .build())
                .build();
    }

    public static PhoneModel getXiaomi() {
        return PhoneModel.builder()
                .id(UUID.randomUUID())
                .img("https://i01.appmifile.com/webfile/globalimg/products/m/mi8/blue-phone.png?1")
                .name("Mi 8")
                .description("Xiaomi Mi 8")
                .price(PhonePriceModel.builder()
                        .currency(EURO_CURRENCY)
                        .value(189.90)
                        .build())
                .build();
    }

    public static PhoneModel getHuawei() {
        return PhoneModel.builder()
                .id(UUID.randomUUID())
                .img("https://consumer.huawei.com/content/dam/huawei-cbg-site/common/mkt/pdp/phones/p40-lite-5g/img/pc/huawei-p40-lite-5g.jpg")
                .name("P40")
                .description("Xiaomi Mi 8")
                .price(PhonePriceModel.builder()
                        .currency(EURO_CURRENCY)
                        .value(279.90)
                        .build())
                .build();
    }
}
