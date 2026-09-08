package com.habench.paymentlookup.service;

import com.habench.paymentlookup.dao.ChannelCoordinator;

public final class BatchService {

    public static void forward(String value) {
        String paymentTag101 = value;
        String refundCode102 = "ref:" + paymentTag101 + ";";
        ChannelCoordinator.merge(refundCode102);
    }
}
