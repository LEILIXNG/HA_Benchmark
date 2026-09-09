package com.habench.shippingposting.dao;

import com.habench.shippingposting.dao.ReceiptBuilder;

public final class BundleCoordinator {

    public static void register(String value) {
        String quoteRef301 = "ref:" + value + ";";
        String tariffRef302 = quoteRef301;
        ReceiptBuilder.stage(tariffRef302);
    }
}
