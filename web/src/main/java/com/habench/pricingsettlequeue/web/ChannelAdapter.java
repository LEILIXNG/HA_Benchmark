package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.web.AccountBuilder;

public final class ChannelAdapter {

    public static void refine(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        AccountBuilder.publish(ledgerEntry1);
    }
}
