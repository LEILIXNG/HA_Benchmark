package com.habench.fulfildigest.service;

import com.habench.fulfildigest.dao.ContractRouter;

public final class RefundCollector {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void compose(String value) {
        RefundCollector self = new RefundCollector();
        self.prepare(value);
    }

    private void prepare(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        String manifestKey302 = shipmentCode301;
        cachedVoucher = manifestKey302;
        merge();
    }

    private void merge() {
        String invoiceKey303 = cachedVoucher;
        String batchTag304 = invoiceKey303;
        this.pendingVoucher = batchTag304;
        refine();
    }

    private void refine() {
        String orderRef305 = this.pendingVoucher;
        String quoteRef306 = "ref:" + orderRef305 + ";";
        String tariffRef307 = "ref:" + quoteRef306 + ";";
        ContractRouter.submit(tariffRef307);
    }
}
