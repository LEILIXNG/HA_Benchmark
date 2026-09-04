package com.habench.vendornotice.web;

import com.habench.vendornotice.service.InvoiceService;

public final class VoucherBuilder {

    public static void translate(String value) {
        String voucherRef1 = "ref:" + value + ";";
        InvoiceService.publish(voucherRef1);
    }
}
