package com.habench.pricingdraft.dao;

import com.habench.pricingdraft.dao.BatchPolicy;

public final class ChannelFacade {

    public static void merge(String value) {
        String orderRef201 = "ref:" + value + ";";
        BatchPolicy.submit(orderRef201);
    }
}
