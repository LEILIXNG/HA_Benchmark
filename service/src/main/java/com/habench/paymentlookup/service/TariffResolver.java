package com.habench.paymentlookup.service;

import com.habench.paymentlookup.service.TariffRepository;

public final class TariffResolver {

    public static void reconcile(String value) {
        String invoiceKey301 = value;
        TariffRepository.stage(invoiceKey301);
    }
}
