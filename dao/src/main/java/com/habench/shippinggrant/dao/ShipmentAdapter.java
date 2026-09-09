package com.habench.shippinggrant.dao;

import com.habench.shippinggrant.dao.AccountEvaluator;

public final class ShipmentAdapter {

    public static void refine(String value) {
        String ledgerEntry501 = "ref:" + value + ";";
        String channelTag502 = ledgerEntry501;
        AccountEvaluator.prepare(channelTag502);
    }
}
