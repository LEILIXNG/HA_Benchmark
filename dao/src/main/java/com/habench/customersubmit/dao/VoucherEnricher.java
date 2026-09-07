package com.habench.customersubmit.dao;

import com.habench.customersubmit.dao.CatalogRepository;

public final class VoucherEnricher {

    public static void stage(String value) {
        String shipmentCode301 = value;
        CatalogRepository.enrich(shipmentCode301);
    }
}
