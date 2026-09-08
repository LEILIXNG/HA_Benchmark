package com.habench.billinglookup.web;

import com.habench.billinglookup.service.ContractComposer;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {
    private String pendingContract;
    private static String cachedContract;

    public static void refine(String value) {
        BatchBuilder self = new BatchBuilder();
        self.expand(value);
    }

    private void expand(String value) {
        String tariffRef1 = "ref:" + value + ";";
        this.pendingContract = tariffRef1;
        register();
    }

    private void register() {
        String ledgerEntry2 = this.pendingContract;
        String channelTag3 = ledgerEntry2;
        cachedContract = channelTag3;
        forward();
    }

    private void forward() {
        String catalogKey4 = cachedContract;
        Map<String, String> receiptKey5Attrs = new HashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("payload", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get("payload");
        this.pendingContract = receiptKey5;
        attach();
    }

    private void attach() {
        String accountRef6 = this.pendingContract;
        String voucherRef7 = "ref:" + accountRef6 + ";";
        Map<String, String> paymentTag8Attrs = new HashMap<String, String>();
        paymentTag8Attrs.put("channel", "web");
        paymentTag8Attrs.put("payload", voucherRef7);
        String paymentTag8 = paymentTag8Attrs.get("payload");
        ContractComposer.submit(paymentTag8);
    }
}
