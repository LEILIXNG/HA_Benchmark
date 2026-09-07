package com.habench.reportassign.web;

import com.habench.reportassign.service.ContractEnricher;

public final class OrderResolver {
    private static String cachedVoucher;

    public static void attach(String value) {
        String invoiceKey101 = value;
        cachedVoucher = invoiceKey101;
        stage();
    }

    private static void stage() {
        String batchTag102 = cachedVoucher;
        String orderRef103 = batchTag102;
        String quoteRef104 = "ref:" + orderRef103 + ";";
        ContractEnricher.expand(quoteRef104);
    }
}
