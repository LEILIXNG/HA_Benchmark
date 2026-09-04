package com.habench.catalogquote.web;

import com.habench.catalogquote.web.ContractPolicySelector;

public final class TariffAssembler {
    private String pendingBatch;

    public static void route(String value) {
        TariffAssembler self = new TariffAssembler();
        self.expand(value);
    }

    private void expand(String value) {
        String invoiceKey1 = value;
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        this.pendingBatch = batchTag2;
        resolve();
    }

    private void resolve() {
        String orderRef3 = this.pendingBatch;
        String quoteRef4 = orderRef3;
        String tariffRef5 = quoteRef4;
        ContractPolicySelector.collect(tariffRef5);
    }
}
