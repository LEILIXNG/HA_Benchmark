package com.habench.reportrollup.dao;

import com.habench.reportrollup.dao.RefundGuard;

public final class InvoiceNormalizer {

    public static void collect(String value) {
        String manifestKey301 = value;
        String invoiceKey302 = manifestKey301;
        RefundGuard.merge(invoiceKey302);
    }
}
