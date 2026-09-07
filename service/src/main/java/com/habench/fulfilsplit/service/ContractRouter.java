package com.habench.fulfilsplit.service;

import com.habench.fulfilsplit.dao.ChannelEnricher;

public final class ContractRouter {

    public static void forward(String value) {
        String invoiceKey101 = value;
        ChannelEnricher.reconcile(invoiceKey101);
    }
}
