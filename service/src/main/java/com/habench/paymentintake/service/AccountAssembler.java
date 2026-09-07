package com.habench.paymentintake.service;

import com.habench.paymentintake.service.ChannelRuleSelector;

public final class AccountAssembler {

    public static void stage(String value) {
        String paymentTag201 = "ref:" + value + ";";
        ChannelRuleSelector.stage(paymentTag201);
    }
}
