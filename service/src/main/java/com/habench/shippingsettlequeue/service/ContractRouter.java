package com.habench.shippingsettlequeue.service;

import com.habench.shippingsettlequeue.dao.ChannelEnricher;

public final class ContractRouter {

    public static void forward(String value) {
        String invoiceKey101 = value;
        ChannelEnricher.reconcile(invoiceKey101);
    }
}
