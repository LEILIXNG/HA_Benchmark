package com.habench.vendorsync.service;

import com.habench.vendorsync.service.RefundService;

public final class ShipmentService {
    private static String cachedBatch;

    public static void register(String value) {
        String manifestKey101 = "ref:" + value + ";";
        cachedBatch = manifestKey101;
        merge();
    }

    private static void merge() {
        String invoiceKey102 = cachedBatch;
        String batchTag103 = "ref:" + invoiceKey102 + ";";
        RefundService.dispatch(batchTag103);
    }
}
