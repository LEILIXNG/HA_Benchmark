package com.habench.vendorlookup.dao;

import com.habench.vendorlookup.dao.BatchPolicy;

public final class ChannelFacade {

    public static void merge(String value) {
        String orderRef201 = "ref:" + value + ";";
        BatchPolicy.submit(orderRef201);
    }
}
