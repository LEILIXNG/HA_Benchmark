package com.habench.billingassign.dao;

import com.habench.billingassign.dao.BundleAdapter;

public final class OrderBroker {

    public static void normalize(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = "ref:" + refundCode201 + ";";
        BundleAdapter.stage(shipmentCode202);
    }
}
