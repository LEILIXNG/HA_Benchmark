package com.habench.paymentreconcile.service;

import com.habench.paymentreconcile.dao.ContractComposer;

public final class VoucherAdapter {

    public static void submit(String value) {
        String invoiceKey101 = value;
        ContractComposer.enrich(invoiceKey101);
    }
}
