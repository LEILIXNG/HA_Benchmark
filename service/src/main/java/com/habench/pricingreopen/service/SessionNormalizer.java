package com.habench.pricingreopen.service;

import com.habench.pricingreopen.dao.ReceiptAssembler;

public final class SessionNormalizer {
    private String pendingAccount;

    public static void resolve(String value) {
        SessionNormalizer self = new SessionNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String tariffRef201 = value;
        this.pendingAccount = tariffRef201;
        merge();
    }

    private void merge() {
        String ledgerEntry202 = this.pendingAccount;
        String channelTag203 = ledgerEntry202;
        String catalogKey204 = "ref:" + channelTag203 + ";";
        this.pendingAccount = catalogKey204;
        route();
    }

    private void route() {
        String receiptKey205 = this.pendingAccount;
        String accountRef206 = receiptKey205;
        ReceiptAssembler.translate(accountRef206);
    }
}
