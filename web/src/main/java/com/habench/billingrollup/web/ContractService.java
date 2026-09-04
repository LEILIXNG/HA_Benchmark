package com.habench.billingrollup.web;

import com.habench.billingrollup.service.BundleRegistry;

public final class ContractService {

    public static void dispatch(String value) {
        String paymentTag1 = value;
        BundleRegistry.refine(paymentTag1);
    }
}
