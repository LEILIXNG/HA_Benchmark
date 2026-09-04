package com.habench.reportmerge.web;

import com.habench.reportmerge.service.OrderCollector;

public final class AccountRegistry {

    public static void refine(String value) {
        String batchTag1 = "ref:" + value + ";";
        OrderCollector.normalize(batchTag1);
    }
}
