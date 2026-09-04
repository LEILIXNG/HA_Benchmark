package com.habench.inventorydispatch.dao;

import com.habench.inventorydispatch.dao.PaymentLoader;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {
    private String pendingPayment;
    private static String cachedPayment;

    public static void dispatch(String value) {
        ContractNormalizer self = new ContractNormalizer();
        self.attach(value);
    }

    private void attach(String value) {
        String refundCode401 = "ref:" + value + ";";
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        cachedPayment = shipmentCode402;
        forward();
    }

    private void forward() {
        String manifestKey403 = cachedPayment;
        Map<String, String> invoiceKey404Attrs = new HashMap<String, String>();
        invoiceKey404Attrs.put("channel", "web");
        invoiceKey404Attrs.put("payload", manifestKey403);
        String invoiceKey404 = invoiceKey404Attrs.get("payload");
        String batchTag405 = invoiceKey404;
        cachedPayment = batchTag405;
        expand();
    }

    private void expand() {
        String orderRef406 = cachedPayment;
        String quoteRef407 = "ref:" + orderRef406 + ";";
        this.pendingPayment = quoteRef407;
        merge();
    }

    private void merge() {
        String tariffRef408 = this.pendingPayment;
        Map<String, String> ledgerEntry409Attrs = new HashMap<String, String>();
        ledgerEntry409Attrs.put("channel", "web");
        ledgerEntry409Attrs.put("payload", tariffRef408);
        String ledgerEntry409 = ledgerEntry409Attrs.get("payload");
        PaymentLoader.forward(ledgerEntry409);
    }
}
