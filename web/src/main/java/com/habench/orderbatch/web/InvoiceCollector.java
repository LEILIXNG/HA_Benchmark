package com.habench.orderbatch.web;

import com.habench.orderbatch.web.ChannelRuleSelector;

public final class InvoiceCollector {

    public static void stage(String value) {
        String channelTag101 = "ref:" + value + ";";
        ChannelRuleSelector.dispatch(channelTag101);
    }
}
