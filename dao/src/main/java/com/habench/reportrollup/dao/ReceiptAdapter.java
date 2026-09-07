package com.habench.reportrollup.dao;

import com.habench.reportrollup.dao.CatalogScreen;

public final class ReceiptAdapter {

    public static void dispatch(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        CatalogScreen.submit(invoiceKey201);
    }
}
