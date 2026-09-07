package com.habench.accountdraft.service;

import com.habench.accountdraft.service.ManifestResolver;

public final class InvoiceFacade {

    public static void forward(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        ManifestResolver.register(shipmentCode101);
    }
}
