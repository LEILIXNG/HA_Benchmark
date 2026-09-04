package com.habench.shippinglookup.dao;

import com.habench.shippinglookup.dao.InvoicePlanSelector;

public final class VoucherResolver {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void stage(String value) {
        VoucherResolver self = new VoucherResolver();
        self.submit(value);
    }

    private void submit(String value) {
        String shipmentCode301 = value;
        String manifestKey302 = shipmentCode301;
        cachedReceipt = manifestKey302;
        prepare();
    }

    private void prepare() {
        String invoiceKey303 = cachedReceipt;
        String batchTag304 = invoiceKey303;
        this.pendingReceipt = batchTag304;
        forward();
    }

    private void forward() {
        String orderRef305 = this.pendingReceipt;
        String quoteRef306 = "ref:" + orderRef305 + ";";
        String tariffRef307 = "ref:" + quoteRef306 + ";";
        InvoicePlanSelector.route(tariffRef307);
    }
}
