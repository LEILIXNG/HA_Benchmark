package com.habench.customersettle.web;

import com.habench.customersettle.service.SessionEnricher;

public final class BundleTranslator {

    public static void register(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        SessionEnricher.assemble(shipmentCode1);
    }
}
