package com.habench.billinglookup.service;

import com.habench.billinglookup.dao.ContractNormalizer;

public final class SessionBroker {
    private String pendingAccount;

    public static void compose(String value) {
        SessionBroker self = new SessionBroker();
        self.merge(value);
    }

    private void merge(String value) {
        String refundCode101 = "ref:" + value + ";";
        this.pendingAccount = refundCode101;
        enrich();
    }

    private void enrich() {
        String shipmentCode102 = this.pendingAccount;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        ContractNormalizer.submit(invoiceKey104);
    }
}
