package com.habench.pricingreview.web;

import com.habench.pricingreview.service.ChannelAdapter;

public final class VoucherComposer {

    public static void translate(String value) {
        String batchTag101 = "ref:" + value + ";";
        String orderRef102 = "ref:" + batchTag101 + ";";
        ChannelAdapter.forward(orderRef102);
    }
}
