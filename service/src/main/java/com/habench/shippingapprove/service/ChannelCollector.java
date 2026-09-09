package com.habench.shippingapprove.service;

import com.habench.shippingapprove.dao.InvoiceComposer;

public final class ChannelCollector {

    public static void refine(String value) {
        String batchTag101 = "ref:" + value + ";";
        InvoiceComposer.reconcile(batchTag101);
    }
}
