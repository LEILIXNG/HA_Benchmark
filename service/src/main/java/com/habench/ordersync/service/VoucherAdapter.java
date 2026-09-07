package com.habench.ordersync.service;

import com.habench.ordersync.dao.ContractComposer;

public final class VoucherAdapter {

    public static void submit(String value) {
        String invoiceKey101 = value;
        ContractComposer.enrich(invoiceKey101);
    }
}
