package com.habench.shippingrollup.service;

import com.habench.shippingrollup.dao.ContractBroker;

public final class RefundRouter {

    public static void stage(String value) {
        String paymentTag101 = "ref:" + value + ";";
        ContractBroker.publish(paymentTag101);
    }
}
