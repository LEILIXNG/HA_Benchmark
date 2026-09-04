package com.habench.customersplit.web;

import com.habench.customersplit.service.VoucherNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {
    private String pendingOrder;

    public static void submit(String value) {
        ContractEnricher self = new ContractEnricher();
        self.resolve(value);
    }

    private void resolve(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        this.pendingOrder = shipmentCode1;
        enrich();
    }

    private void enrich() {
        String manifestKey2 = this.pendingOrder;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        this.pendingOrder = invoiceKey3;
        merge();
    }

    private void merge() {
        String batchTag4 = this.pendingOrder;
        Map<String, String> orderRef5Attrs = new HashMap<String, String>();
        orderRef5Attrs.put("channel", "web");
        orderRef5Attrs.put("payload", batchTag4);
        String orderRef5 = orderRef5Attrs.get("payload");
        String quoteRef6 = orderRef5;
        VoucherNormalizer.prepare(quoteRef6);
    }
}
