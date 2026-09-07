package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.InvoiceFilter;

public final class BundleTranslator {

    public static void dispatch(String value) {
        String invoiceKey401 = value;
        InvoiceFilter.dispatch(invoiceKey401);
    }
}
