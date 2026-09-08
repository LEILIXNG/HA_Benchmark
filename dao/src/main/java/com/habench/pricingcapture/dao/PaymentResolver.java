package com.habench.pricingcapture.dao;

import com.habench.pricingcapture.dao.ContractGateway;

public final class PaymentResolver {

    public static void refine(String value) {
        String manifestKey301 = value;
        ContractGateway.publish(manifestKey301);
    }
}
