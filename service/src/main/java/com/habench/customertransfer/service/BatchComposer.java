package com.habench.customertransfer.service;

import com.habench.customertransfer.service.BatchPolicySelector;

public final class BatchComposer {

    public static void prepare(String value) {
        String accountRef201 = "ref:" + value + ";";
        BatchPolicySelector.collect(accountRef201);
    }
}
