package com.habench.orderadjust.dao;

import com.habench.orderadjust.dao.CatalogScreen;

public final class ReceiptAdapter {

    public static void dispatch(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        CatalogScreen.submit(invoiceKey201);
    }
}
