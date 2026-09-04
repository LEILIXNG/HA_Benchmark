package com.habench.customersubmit.service;

import com.habench.customersubmit.service.CatalogRepository;

public final class VoucherEnricher {

    public static void stage(String value) {
        String receiptKey701 = value;
        CatalogRepository.enrich(receiptKey701);
    }
}
