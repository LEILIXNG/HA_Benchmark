package com.habench.vendornotice.service;

import com.habench.vendornotice.dao.AccountAdapter;

public final class ChannelAdapter {

    public static void collect(String value) {
        String invoiceKey401 = "ref:" + value + ";";
        String batchTag402 = "ref:" + invoiceKey401 + ";";
        AccountAdapter.refine(batchTag402);
    }
}
