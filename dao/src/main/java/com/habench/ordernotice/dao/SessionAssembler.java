package com.habench.ordernotice.dao;

import com.habench.ordernotice.dao.VoucherRuleSelector;

public final class SessionAssembler {

    public static void reconcile(String value) {
        String channelTag401 = "ref:" + value + ";";
        VoucherRuleSelector.attach(channelTag401);
    }
}
