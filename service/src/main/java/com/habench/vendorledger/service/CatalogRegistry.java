package com.habench.vendorledger.service;

import com.habench.vendorledger.dao.RefundAssembler;

public final class CatalogRegistry {

    public static void submit(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        String manifestKey202 = shipmentCode201;
        RefundAssembler.reconcile(manifestKey202);
    }
}
