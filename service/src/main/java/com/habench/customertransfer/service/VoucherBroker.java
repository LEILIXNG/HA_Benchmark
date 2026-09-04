package com.habench.customertransfer.service;

import com.habench.customertransfer.service.AccountRepository;

public final class VoucherBroker {

    public static void expand(String value) {
        String manifestKey401 = "ref:" + value + ";";
        String invoiceKey402 = "ref:" + manifestKey401 + ";";
        AccountRepository.route(invoiceKey402);
    }
}
