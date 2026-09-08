package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.service.TariffRepository;

public final class TariffResolver {

    public static void reconcile(String value) {
        String invoiceKey301 = value;
        TariffRepository.stage(invoiceKey301);
    }
}
