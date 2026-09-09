package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.web.AccountComposer;

public final class ContractBuilder {

    public static void publish(String value) {
        String refundCode101 = "ref:" + value + ";";
        String shipmentCode102 = refundCode101;
        AccountComposer.compose(shipmentCode102);
    }
}
