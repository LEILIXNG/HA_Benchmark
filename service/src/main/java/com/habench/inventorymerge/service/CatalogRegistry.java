package com.habench.inventorymerge.service;

import com.habench.inventorymerge.service.RefundRepository;

public final class CatalogRegistry {

    public static void publish(String value) {
        String shipmentCode401 = "ref:" + value + ";";
        String manifestKey402 = "ref:" + shipmentCode401 + ";";
        RefundRepository.publish(manifestKey402);
    }
}
