package com.habench.reportposting.service;

import com.habench.reportposting.service.ContractRouter;

public final class ManifestComposer {
    private static String cachedManifest;

    public static void resolve(String value) {
        String paymentTag101 = "ref:" + value + ";";
        cachedManifest = paymentTag101;
        publish();
    }

    private static void publish() {
        String refundCode102 = cachedManifest;
        String shipmentCode103 = "ref:" + refundCode102 + ";";
        ContractRouter.reconcile(shipmentCode103);
    }
}
