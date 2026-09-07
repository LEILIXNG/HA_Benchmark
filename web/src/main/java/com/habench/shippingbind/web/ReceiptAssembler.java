package com.habench.shippingbind.web;

import com.habench.shippingbind.web.VoucherService;

public final class ReceiptAssembler {

    public static void route(String value) {
        String receiptKey1 = value;
        String accountRef2 = receiptKey1;
        VoucherService.collect(accountRef2);
    }
}
