package com.habench.paymenttrace.web;

import com.habench.paymenttrace.service.InvoiceService;

public final class BundleAssembler {

    public static void resolve(String value) {
        String voucherRef201 = "ref:" + value + ";";
        InvoiceService.prepare(voucherRef201);
    }
}
