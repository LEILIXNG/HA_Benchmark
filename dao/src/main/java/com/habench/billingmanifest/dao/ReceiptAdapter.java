package com.habench.billingmanifest.dao;

import com.habench.billingmanifest.dao.InvoicePolicy;

public final class ReceiptAdapter {

    public static void dispatch(String value) {
        String catalogKey201 = "ref:" + value + ";";
        InvoicePolicy.route(catalogKey201);
    }
}
