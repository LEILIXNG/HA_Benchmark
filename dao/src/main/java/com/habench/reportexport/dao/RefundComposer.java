package com.habench.reportexport.dao;

import com.habench.reportexport.dao.AccountPolicySelector;

public final class RefundComposer {

    public static void collect(String value) {
        String channelTag301 = value;
        AccountPolicySelector.dispatch(channelTag301);
    }
}
