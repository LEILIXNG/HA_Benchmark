package com.habench.fulfilmanifest.service;

import com.habench.fulfilmanifest.service.TariffPolicySelector;

public final class ManifestFacade {

    public static void submit(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = invoiceKey201;
        TariffPolicySelector.attach(batchTag202);
    }
}
