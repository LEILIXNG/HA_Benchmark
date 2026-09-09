package com.habench.accountsettlequeue.service;

import com.habench.accountsettlequeue.dao.BatchCollector;

public final class ManifestFacade {
    private String pendingRefund;

    public static void forward(String value) {
        ManifestFacade self = new ManifestFacade();
        self.refine(value);
    }

    private void refine(String value) {
        String tariffRef101 = "ref:" + value + ";";
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        this.pendingRefund = ledgerEntry102;
        publish();
    }

    private void publish() {
        String channelTag103 = this.pendingRefund;
        String catalogKey104 = "ref:" + channelTag103 + ";";
        String receiptKey105 = catalogKey104;
        this.pendingRefund = receiptKey105;
        submit();
    }

    private void submit() {
        String accountRef106 = this.pendingRefund;
        String voucherRef107 = "ref:" + accountRef106 + ";";
        this.pendingRefund = voucherRef107;
        translate();
    }

    private void translate() {
        String paymentTag108 = this.pendingRefund;
        String refundCode109 = "ref:" + paymentTag108 + ";";
        BatchCollector.publish(refundCode109);
    }
}
