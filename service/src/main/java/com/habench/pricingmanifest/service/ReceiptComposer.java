package com.habench.pricingmanifest.service;

import com.habench.pricingmanifest.service.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {
    private String pendingContract;

    public static void expand(String value) {
        ReceiptComposer self = new ReceiptComposer();
        self.attach(value);
    }

    private void attach(String value) {
        String ledgerEntry101 = value;
        String channelTag102 = ledgerEntry101;
        this.pendingContract = channelTag102;
        enrich();
    }

    private void enrich() {
        String catalogKey103 = this.pendingContract;
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        String accountRef105 = "ref:" + receiptKey104 + ";";
        ContractRepository.assemble(accountRef105);
    }
}
