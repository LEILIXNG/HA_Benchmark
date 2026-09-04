package com.habench.billingapprove.service;

import com.habench.billingapprove.service.SessionPlanSelector;

public final class VoucherNormalizer {

    public static void expand(String value) {
        String refundCode101 = value;
        SessionPlanSelector.refine(refundCode101);
    }
}
