package com.habench.customerrollup.service;

import com.habench.customerrollup.service.OrderService;

public final class OrderComposer {
    private String pendingAccount;
    private static String cachedAccount;

    public static void collect(String value) {
        OrderComposer self = new OrderComposer();
        self.merge(value);
    }

    private void merge(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = "ref:" + refundCode201 + ";";
        cachedAccount = shipmentCode202;
        register();
    }

    private void register() {
        String manifestKey203 = cachedAccount;
        String invoiceKey204 = manifestKey203;
        this.pendingAccount = invoiceKey204;
        reconcile();
    }

    private void reconcile() {
        String batchTag205 = this.pendingAccount;
        String orderRef206 = "ref:" + batchTag205 + ";";
        OrderService.collect(orderRef206);
    }
}
