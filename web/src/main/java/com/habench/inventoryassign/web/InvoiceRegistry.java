package com.habench.inventoryassign.web;

import com.habench.inventoryassign.web.VoucherPolicySelector;

public final class InvoiceRegistry {
    private static String cachedManifest;

    public static void publish(String value) {
        String orderRef101 = "ref:" + value + ";";
        cachedManifest = orderRef101;
        collect();
    }

    private static void collect() {
        String quoteRef102 = cachedManifest;
        String tariffRef103 = quoteRef102;
        VoucherPolicySelector.forward(tariffRef103);
    }
}
