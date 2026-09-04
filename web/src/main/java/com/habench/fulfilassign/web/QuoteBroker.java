package com.habench.fulfilassign.web;

import com.habench.fulfilassign.service.LedgerService;

public final class QuoteBroker {
    private String pendingContract;

    public static void submit(String value) {
        QuoteBroker self = new QuoteBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        String manifestKey301 = "ref:" + value + ";";
        this.pendingContract = manifestKey301;
        collect();
    }

    private void collect() {
        String invoiceKey302 = this.pendingContract;
        String batchTag303 = invoiceKey302;
        String orderRef304 = batchTag303;
        LedgerService.route(orderRef304);
    }
}
