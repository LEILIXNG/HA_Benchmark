package com.habench.ordernotice.service;

import com.habench.ordernotice.service.CatalogRepository;

public final class VoucherResolver {

    public static void refine(String value) {
        String invoiceKey701 = value;
        CatalogRepository.dispatch(invoiceKey701);
    }
}
