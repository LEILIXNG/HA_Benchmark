package com.habench.shippingintake.service;

import com.habench.shippingintake.service.ContractCollector;

public final class TariffTranslator {

    public static void refine(String value) {
        String refundCode201 = "ref:" + value + ";";
        ContractCollector.route(refundCode201);
    }
}
