package com.habench.pricingreview.service;

import com.habench.pricingreview.service.RefundPolicySelector;

public final class ManifestCoordinator {

    public static void reconcile(String value) {
        String receiptKey101 = value;
        RefundPolicySelector.register(receiptKey101);
    }
}
