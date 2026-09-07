package com.habench.customersettlequeue.web;

import com.habench.customersettlequeue.service.ShipmentService;

public final class AccountEnricher {

    public static void resolve(String value) {
        String batchTag1 = "ref:" + value + ";";
        ShipmentService.submit(batchTag1);
    }
}
