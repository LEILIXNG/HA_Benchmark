package com.habench.vendorreconcile.service;

import com.habench.vendorreconcile.service.TariffRepository;

public final class TariffResolver {

    public static void reconcile(String value) {
        String invoiceKey301 = value;
        TariffRepository.stage(invoiceKey301);
    }
}
