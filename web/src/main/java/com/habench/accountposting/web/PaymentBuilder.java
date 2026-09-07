package com.habench.accountposting.web;

import com.habench.accountposting.web.OrderNormalizer;

public final class PaymentBuilder {

    public static void resolve(String value) {
        String orderRef1 = "ref:" + value + ";";
        OrderNormalizer.collect(orderRef1);
    }
}
