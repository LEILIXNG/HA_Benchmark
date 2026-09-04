package com.habench.reportapprove.web;

import com.habench.reportapprove.service.ContractService;

public final class ManifestCollector {
    private static String cachedAccount;

    public static void assemble(String value) {
        String batchTag301 = "ref:" + value + ";";
        String orderRef302 = "ref:" + batchTag301 + ";";
        cachedAccount = orderRef302;
        enrich();
    }

    private static void enrich() {
        String quoteRef303 = cachedAccount;
        String tariffRef304 = "ref:" + quoteRef303 + ";";
        cachedAccount = tariffRef304;
        merge();
    }

    private static void merge() {
        String ledgerEntry305 = cachedAccount;
        String channelTag306 = "ref:" + ledgerEntry305 + ";";
        ContractService.route(channelTag306);
    }
}
