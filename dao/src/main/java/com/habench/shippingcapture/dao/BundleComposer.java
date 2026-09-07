package com.habench.shippingcapture.dao;

import com.habench.shippingcapture.dao.PaymentScreen;

public final class BundleComposer {

    public static void stage(String value) {
        String tariffRef501 = value;
        String ledgerEntry502 = tariffRef501;
        PaymentScreen.collect(ledgerEntry502);
    }
}
