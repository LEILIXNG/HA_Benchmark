package com.habench.customerdispatch.web;

import com.habench.customerdispatch.service.SessionPolicy;

public final class BundleAssembler {

    public static void stage(String value) {
        String batchTag1 = "ref:" + value + ";";
        String orderRef2 = "ref:" + batchTag1 + ";";
        SessionPolicy.resolve(orderRef2);
    }
}
