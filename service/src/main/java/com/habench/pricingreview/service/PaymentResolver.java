package com.habench.pricingreview.service;

import com.habench.pricingreview.dao.AccountCollector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentResolver {
    private String pendingChannel;
    private static String cachedChannel;

    public static void translate(String value) {
        PaymentResolver self = new PaymentResolver();
        self.refine(value);
    }

    private void refine(String value) {
        String batchTag401 = "ref:" + value + ";";
        Map<String, String> orderRef402Attrs = new HashMap<String, String>();
        orderRef402Attrs.put("channel", "web");
        orderRef402Attrs.put("payload", batchTag401);
        String orderRef402 = orderRef402Attrs.get("payload");
        this.pendingChannel = orderRef402;
        expand();
    }

    private void expand() {
        String quoteRef403 = this.pendingChannel;
        Map<String, String> tariffRef404Attrs = new HashMap<String, String>();
        tariffRef404Attrs.put("channel", "web");
        tariffRef404Attrs.put("payload", quoteRef403);
        String tariffRef404 = tariffRef404Attrs.get("payload");
        cachedChannel = tariffRef404;
        merge();
    }

    private void merge() {
        String ledgerEntry405 = cachedChannel;
        String channelTag406 = ledgerEntry405;
        String catalogKey407 = "ref:" + channelTag406 + ";";
        this.pendingChannel = catalogKey407;
        resolve();
    }

    private void resolve() {
        String receiptKey408 = this.pendingChannel;
        String accountRef409 = "ref:" + receiptKey408 + ";";
        AccountCollector.attach(accountRef409);
    }
}
