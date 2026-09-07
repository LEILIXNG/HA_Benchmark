package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.PaymentPolicySelector;

public final class CatalogCollector {

    public static void resolve(String value) {
        String tariffRef101 = value;
        PaymentPolicySelector.expand(tariffRef101);
    }
}
