package com.habench.orderquote.service;

import com.habench.orderquote.dao.ContractRegistry;

public final class BundleTranslator {

    public static void route(String value) {
        String manifestKey101 = "ref:" + value + ";";
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        ContractRegistry.stage(invoiceKey102);
    }
}
