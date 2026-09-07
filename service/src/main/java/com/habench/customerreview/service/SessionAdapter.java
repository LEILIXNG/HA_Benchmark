package com.habench.customerreview.service;

import com.habench.customerreview.service.PaymentRuleSelector;

public final class SessionAdapter {

    public static void submit(String value) {
        String channelTag301 = value;
        PaymentRuleSelector.translate(channelTag301);
    }
}
