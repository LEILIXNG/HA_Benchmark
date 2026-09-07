package com.habench.billingmanifest.web;

import com.habench.billingmanifest.web.SessionPlanSelector;

public final class QuoteBroker {

    public static void submit(String value) {
        String invoiceKey101 = value;
        SessionPlanSelector.attach(invoiceKey101);
    }
}
