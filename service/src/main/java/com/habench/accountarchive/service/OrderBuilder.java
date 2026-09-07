package com.habench.accountarchive.service;

import com.habench.accountarchive.service.TariffEvaluator;

public final class OrderBuilder {

    public static void route(String value) {
        String tariffRef301 = value;
        TariffEvaluator.prepare(tariffRef301);
    }
}
