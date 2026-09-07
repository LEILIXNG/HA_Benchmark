package com.habench.paymenthold.web;

import com.habench.paymenthold.service.ContractAdapter;

public final class SessionRouter {

    public static void merge(String value) {
        String channelTag1 = "ref:" + value + ";";
        ContractAdapter.translate(channelTag1);
    }
}
