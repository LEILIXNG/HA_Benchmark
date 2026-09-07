package com.habench.ordercapture.dao;

import com.habench.ordercapture.dao.BundlePolicy;

public final class BatchNormalizer {

    public static void route(String value) {
        String batchTag401 = value;
        BundlePolicy.reconcile(batchTag401);
    }
}
