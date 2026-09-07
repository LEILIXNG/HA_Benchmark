package com.habench.paymenttrace.dao;

import com.habench.paymenttrace.dao.SessionEvaluator;

public final class InvoiceService {
    private String pendingSession;
    private static String cachedSession;

    public static void enrich(String value) {
        InvoiceService self = new InvoiceService();
        self.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey401 = value;
        cachedSession = invoiceKey401;
        dispatch();
    }

    private void dispatch() {
        String batchTag402 = cachedSession;
        String orderRef403 = "ref:" + batchTag402 + ";";
        this.pendingSession = orderRef403;
        stage();
    }

    private void stage() {
        String quoteRef404 = this.pendingSession;
        String tariffRef405 = "ref:" + quoteRef404 + ";";
        SessionEvaluator.publish(tariffRef405);
    }
}
