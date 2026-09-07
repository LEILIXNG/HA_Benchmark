package com.habench.customertransfer.service;

import com.habench.customertransfer.service.AccountRepository;

public final class VoucherBroker {

    public static void expand(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        AccountRepository.route(shipmentCode301);
    }
}
