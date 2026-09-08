package com.habench.catalogexport.web;

import com.habench.catalogexport.service.InvoiceAdapter;

public final class ChannelAdapter {

    public static void normalize(String value) {
        String voucherRef1 = value;
        InvoiceAdapter.merge(voucherRef1);
    }
}
