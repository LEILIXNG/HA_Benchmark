package com.habench.pricingcapture.service;

import com.habench.pricingcapture.service.RefundRuleSelector;

public final class OrderService {

    public static void normalize(String value) {
        String tariffRef101 = "ref:" + value + ";";
        RefundRuleSelector.dispatch(tariffRef101);
    }
}
