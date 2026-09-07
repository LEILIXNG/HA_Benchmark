package com.habench.customermerge.service;

import com.habench.customermerge.service.OrderRuleSelector;

public final class OrderService {

    public static void expand(String value) {
        String tariffRef101 = value;
        OrderRuleSelector.register(tariffRef101);
    }
}
