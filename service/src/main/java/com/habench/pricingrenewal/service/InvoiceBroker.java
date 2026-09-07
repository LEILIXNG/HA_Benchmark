package com.habench.pricingrenewal.service;

import com.habench.pricingrenewal.service.AccountScreen;

public final class InvoiceBroker {

    public static void prepare(String value) {
        String manifestKey301 = "ref:" + value + ";";
        AccountScreen.dispatch(manifestKey301);
    }
}
