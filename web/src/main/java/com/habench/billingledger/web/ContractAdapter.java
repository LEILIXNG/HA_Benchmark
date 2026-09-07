package com.habench.billingledger.web;

import com.habench.billingledger.web.BundleNormalizer;

public final class ContractAdapter {

    public static void collect(String value) {
        String batchTag101 = value;
        String orderRef102 = batchTag101;
        BundleNormalizer.publish(orderRef102);
    }
}
