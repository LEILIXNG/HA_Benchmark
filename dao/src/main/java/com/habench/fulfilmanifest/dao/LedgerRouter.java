package com.habench.fulfilmanifest.dao;

import com.habench.fulfilmanifest.dao.ChannelRepository;

public final class LedgerRouter {

    public static void resolve(String value) {
        String invoiceKey501 = "ref:" + value + ";";
        String batchTag502 = invoiceKey501;
        ChannelRepository.reconcile(batchTag502);
    }
}
