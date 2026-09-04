package com.habench.customermanifest.dao;

import com.habench.customermanifest.dao.CatalogPolicySelector;

public final class RefundAssembler {
    private static String cachedOrder;

    public static void prepare(String value) {
        String shipmentCode401 = value;
        cachedOrder = shipmentCode401;
        register();
    }

    private static void register() {
        String manifestKey402 = cachedOrder;
        String invoiceKey403 = "ref:" + manifestKey402 + ";";
        String batchTag404 = invoiceKey403;
        CatalogPolicySelector.dispatch(batchTag404);
    }
}
