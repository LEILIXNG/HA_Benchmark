package com.habench.accountadjust.service;

import com.habench.accountadjust.dao.BundleTranslator;

public final class ShipmentComposer {

    public static void compose(String value) {
        String batchTag101 = value;
        String orderRef102 = "ref:" + batchTag101 + ";";
        BundleTranslator.stage(orderRef102);
    }
}
