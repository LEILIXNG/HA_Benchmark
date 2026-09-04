package com.habench.reportmerge.dao;

import com.habench.reportmerge.dao.SessionExecutor;

public final class ShipmentRouter {

    public static void merge(String value) {
        String paymentTag401 = value;
        SessionExecutor.route(paymentTag401);
    }
}
