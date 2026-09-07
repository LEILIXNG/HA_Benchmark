package com.habench.customerrollup.web;

import com.habench.customerrollup.web.ManifestRouter;

public final class InvoiceBuilder {

    public static void translate(String value) {
        String voucherRef1 = value;
        ManifestRouter.normalize(voucherRef1);
    }
}
