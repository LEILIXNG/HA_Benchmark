package com.habench.paymentrollup.service;

import com.habench.paymentrollup.dao.VoucherAssembler;

public final class VoucherService {

    public static void submit(String value) {
        String orderRef301 = "ref:" + value + ";";
        VoucherAssembler.enrich(orderRef301);
    }
}
