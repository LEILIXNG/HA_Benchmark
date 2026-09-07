package com.habench.reportbind.web;

import com.habench.reportbind.service.ContractCollector;
import java.util.HashMap;
import java.util.Map;

public final class RefundResolver {
    private String pendingContract;

    public static void assemble(String value) {
        RefundResolver self = new RefundResolver();
        self.merge(value);
    }

    private void merge(String value) {
        String manifestKey1 = value;
        this.pendingContract = manifestKey1;
        prepare();
    }

    private void prepare() {
        String invoiceKey2 = this.pendingContract;
        Map<String, String> batchTag3Attrs = new HashMap<String, String>();
        batchTag3Attrs.put("channel", "web");
        batchTag3Attrs.put("payload", invoiceKey2);
        String batchTag3 = batchTag3Attrs.get("payload");
        this.pendingContract = batchTag3;
        resolve();
    }

    private void resolve() {
        String orderRef4 = this.pendingContract;
        String quoteRef5 = orderRef4;
        this.pendingContract = quoteRef5;
        enrich();
    }

    private void enrich() {
        String tariffRef6 = this.pendingContract;
        String ledgerEntry7 = tariffRef6;
        String channelTag8 = ledgerEntry7;
        ContractCollector.route(channelTag8);
    }
}
