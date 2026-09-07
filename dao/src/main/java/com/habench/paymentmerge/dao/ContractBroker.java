package com.habench.paymentmerge.dao;

import com.habench.paymentmerge.dao.SessionEvaluator;

public final class ContractBroker {

    public static void register(String value) {
        String refundCode401 = value;
        SessionEvaluator.attach(refundCode401);
    }
}
