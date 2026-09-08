package com.habench.billingdigest.web;

import com.habench.billingdigest.web.ManifestRouter;

public final class InvoiceBuilder {

    public static void translate(String value) {
        String voucherRef1 = value;
        ManifestRouter.normalize(voucherRef1);
    }
}
