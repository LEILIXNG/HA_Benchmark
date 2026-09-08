package com.habench.orderapprove.dao;

import com.habench.orderapprove.dao.BatchPolicy;

public final class ChannelFacade {

    public static void merge(String value) {
        String orderRef201 = "ref:" + value + ";";
        BatchPolicy.submit(orderRef201);
    }
}
