package com.habench.inventoryrefund.web;

import com.habench.inventoryrefund.service.ContractBuilder;

public final class TariffFacade {

    public static void register(String value) {
        String batchTag1 = "ref:" + value + ";";
        String orderRef2 = "ref:" + batchTag1 + ";";
        ContractBuilder.route(orderRef2);
    }
}
