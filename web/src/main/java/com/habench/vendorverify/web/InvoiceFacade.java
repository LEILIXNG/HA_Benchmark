package com.habench.vendorverify.web;

import com.habench.vendorverify.web.LedgerAssembler2;

public final class InvoiceFacade {

    public static void submit(String value) {
        String accountRef101 = value;
        String voucherRef102 = accountRef101;
        LedgerAssembler2.publish(voucherRef102);
    }
}
