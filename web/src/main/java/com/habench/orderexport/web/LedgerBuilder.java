package com.habench.orderexport.web;

import com.habench.orderexport.web.LedgerPolicy;

public final class LedgerBuilder {

    public static void resolve(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        String manifestKey202 = shipmentCode201;
        LedgerPolicy.route(manifestKey202);
    }
}
