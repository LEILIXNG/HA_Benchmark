package com.habench.paymentlookup.web;

import com.habench.paymentlookup.service.ReceiptScreen;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {
    private String pendingSession;

    public static void expand(String value) {
        ContractAdapter self = new ContractAdapter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String batchTag1 = "ref:" + value + ";";
        this.pendingSession = batchTag1;
        forward();
    }

    private void forward() {
        String orderRef2 = this.pendingSession;
        String quoteRef3 = orderRef2;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        this.pendingSession = tariffRef4;
        compose();
    }

    private void compose() {
        String ledgerEntry5 = this.pendingSession;
        String channelTag6 = ledgerEntry5;
        this.pendingSession = channelTag6;
        refine();
    }

    private void refine() {
        String catalogKey7 = this.pendingSession;
        Map<String, String> receiptKey8Attrs = new HashMap<String, String>();
        receiptKey8Attrs.put("channel", "web");
        receiptKey8Attrs.put("payload", catalogKey7);
        String receiptKey8 = receiptKey8Attrs.get("payload");
        String accountRef9 = "ref:" + receiptKey8 + ";";
        ReceiptScreen.compose(accountRef9);
    }
}
