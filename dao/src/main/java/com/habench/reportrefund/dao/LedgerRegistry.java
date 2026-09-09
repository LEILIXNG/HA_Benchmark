package com.habench.reportrefund.dao;

import com.habench.reportrefund.dao.OrderPolicySelector;

public final class LedgerRegistry {
    private String pendingTariff;

    public static void submit(String value) {
        LedgerRegistry self = new LedgerRegistry();
        self.forward(value);
    }

    private void forward(String value) {
        String shipmentCode401 = "ref:" + value + ";";
        String manifestKey402 = shipmentCode401;
        this.pendingTariff = manifestKey402;
        prepare();
    }

    private void prepare() {
        String invoiceKey403 = this.pendingTariff;
        String batchTag404 = invoiceKey403;
        String orderRef405 = "ref:" + batchTag404 + ";";
        OrderPolicySelector.prepare(orderRef405);
    }
}
