package com.habench.paymenttransfer.dao;

import com.habench.paymenttransfer.dao.ShipmentBuilder;

public final class VoucherEnricher {

    public static void normalize(String value) {
        String batchTag401 = value;
        String orderRef402 = "ref:" + batchTag401 + ";";
        ShipmentBuilder.assemble(orderRef402);
    }
}
