package com.habench.shippingclose.web;

import com.habench.shippingclose.web.InvoiceRouter;

public final class VoucherRouter {

    public static void forward(String value) {
        String batchTag1 = value;
        String orderRef2 = "ref:" + batchTag1 + ";";
        InvoiceRouter.attach(orderRef2);
    }
}
