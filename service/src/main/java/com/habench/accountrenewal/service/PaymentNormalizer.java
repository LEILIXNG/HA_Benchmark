package com.habench.accountrenewal.service;

import com.habench.accountrenewal.service.ContractEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentNormalizer {
    private String pendingContract;

    public static void assemble(String value) {
        PaymentNormalizer self = new PaymentNormalizer();
        self.attach(value);
    }

    private void attach(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        String manifestKey102 = "ref:" + shipmentCode101 + ";";
        this.pendingContract = manifestKey102;
        submit();
    }

    private void submit() {
        String invoiceKey103 = this.pendingContract;
        Map<String, String> batchTag104Attrs = new HashMap<String, String>();
        batchTag104Attrs.put("channel", "web");
        batchTag104Attrs.put("payload", invoiceKey103);
        String batchTag104 = batchTag104Attrs.get("payload");
        String orderRef105 = "ref:" + batchTag104 + ";";
        ContractEvaluator.compose(orderRef105);
    }
}
