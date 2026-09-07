package com.habench.accountadjust.dao;

import com.habench.accountadjust.dao.BundleGuard;

public final class BundleTranslator {

    public static void stage(String value) {
        String paymentTag201 = value;
        BundleGuard.submit(paymentTag201);
    }
}
