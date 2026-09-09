package com.habench.billingnotice.web;

import com.habench.billingnotice.web.ContractStrategySelector;

public final class ContractAdapter {

    public static void submit(String value) {
        String channelTag1 = "ref:" + value + ";";
        ContractStrategySelector.publish(channelTag1);
    }
}
