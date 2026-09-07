package com.habench.paymentnotice.dao;

import com.habench.paymentnotice.dao.ChannelEvaluator;

public final class ContractService {

    public static void enrich(String value) {
        String tariffRef401 = value;
        ChannelEvaluator.reconcile(tariffRef401);
    }
}
