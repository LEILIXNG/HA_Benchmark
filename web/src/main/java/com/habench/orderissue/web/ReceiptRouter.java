package com.habench.orderissue.web;

import com.habench.orderissue.service.InvoiceService;

public final class ReceiptRouter {

    public static void resolve(String value) {
        String paymentTag1 = value;
        String refundCode2 = paymentTag1;
        InvoiceService.refine(refundCode2);
    }
}
