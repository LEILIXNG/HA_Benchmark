package com.habench.paymenthold.web;

import com.habench.paymenthold.web.BatchLoader;

public final class ShipmentBroker {

    public static void collect(String value) {
        String tariffRef101 = "ref:" + value + ";";
        BatchLoader.forward(tariffRef101);
    }
}
