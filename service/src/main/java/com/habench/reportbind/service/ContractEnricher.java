package com.habench.reportbind.service;

import com.habench.reportbind.service.LedgerPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {
    private String pendingContract;

    public static void enrich(String value) {
        ContractEnricher self = new ContractEnricher();
        self.assemble(value);
    }

    private void assemble(String value) {
        String tariffRef201 = "ref:" + value + ";";
        this.pendingContract = tariffRef201;
        merge();
    }

    private void merge() {
        String ledgerEntry202 = this.pendingContract;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        this.pendingContract = channelTag203;
        prepare();
    }

    private void prepare() {
        String catalogKey204 = this.pendingContract;
        Map<String, String> receiptKey205Attrs = new HashMap<String, String>();
        receiptKey205Attrs.put("channel", "web");
        receiptKey205Attrs.put("payload", catalogKey204);
        String receiptKey205 = receiptKey205Attrs.get("payload");
        String accountRef206 = "ref:" + receiptKey205 + ";";
        LedgerPolicy.reconcile(accountRef206);
    }
}
