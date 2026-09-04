package com.habench.customerrelease.web;

import com.habench.customerrelease.web.ChannelAdapter;

public final class VoucherAssembler {

    public static void submit(String value) {
        String tariffRef1 = "ref:" + value + ";";
        String ledgerEntry2 = tariffRef1;
        ChannelAdapter.submit(ledgerEntry2);
    }
}
