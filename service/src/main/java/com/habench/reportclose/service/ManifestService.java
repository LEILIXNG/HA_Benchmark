package com.habench.reportclose.service;

import com.habench.reportclose.dao.VoucherAssembler;

public final class ManifestService {
    private String pendingChannel;
    private static String cachedChannel;

    public static void refine(String value) {
        ManifestService self = new ManifestService();
        self.merge(value);
    }

    private void merge(String value) {
        String tariffRef101 = "ref:" + value + ";";
        this.pendingChannel = tariffRef101;
        enrich();
    }

    private void enrich() {
        String ledgerEntry102 = this.pendingChannel;
        String channelTag103 = ledgerEntry102;
        cachedChannel = channelTag103;
        stage();
    }

    private void stage() {
        String catalogKey104 = cachedChannel;
        String receiptKey105 = "ref:" + catalogKey104 + ";";
        VoucherAssembler.normalize(receiptKey105);
    }
}
