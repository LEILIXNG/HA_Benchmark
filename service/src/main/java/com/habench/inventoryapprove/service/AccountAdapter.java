package com.habench.inventoryapprove.service;

import com.habench.inventoryapprove.dao.InvoiceBuilder;

public final class AccountAdapter {
    private static String cachedCatalog;

    public static void expand(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = catalogKey201;
        cachedCatalog = receiptKey202;
        translate();
    }

    private static void translate() {
        String accountRef203 = cachedCatalog;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        InvoiceBuilder.route(voucherRef204);
    }
}
