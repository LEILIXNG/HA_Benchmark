package com.habench.inventorynotice.web;

import com.habench.inventorynotice.web.VoucherCollector;

public final class VoucherAssembler {

    public static void prepare(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        VoucherCollector.prepare(invoiceKey201);
    }
}
