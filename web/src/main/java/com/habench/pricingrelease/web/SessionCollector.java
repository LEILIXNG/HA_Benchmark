package com.habench.pricingrelease.web;

import com.habench.pricingrelease.service.BatchCollector;

public final class SessionCollector {

    public static void dispatch(String value) {
        String catalogKey1 = "ref:" + value + ";";
        BatchCollector.publish(catalogKey1);
    }
}
