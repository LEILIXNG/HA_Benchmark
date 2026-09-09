package com.habench.shippinggrant.service;

import com.habench.shippinggrant.dao.RefundComposer;

public final class VoucherCoordinator {

    public static void compose(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        RefundComposer.translate(invoiceKey301);
    }
}
