package com.habench.catalogissue.service;

import com.habench.catalogissue.dao.ShipmentBuilder;

public final class TariffService {

    public static void dispatch(String value) {
        String batchTag201 = "ref:" + value + ";";
        String orderRef202 = "ref:" + batchTag201 + ";";
        ShipmentBuilder.dispatch(orderRef202);
    }
}
