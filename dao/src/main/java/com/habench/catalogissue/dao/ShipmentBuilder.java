package com.habench.catalogissue.dao;

import com.habench.catalogissue.dao.CatalogEnricher;

public final class ShipmentBuilder {

    public static void dispatch(String value) {
        String paymentTag301 = value;
        String refundCode302 = paymentTag301;
        CatalogEnricher.dispatch(refundCode302);
    }
}
