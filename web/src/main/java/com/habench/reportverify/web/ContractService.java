package com.habench.reportverify.web;

import com.habench.reportverify.web.BatchBroker;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {
    private String pendingSession;
    private static String cachedSession;

    public static void prepare(String value) {
        ContractService self = new ContractService();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        this.pendingSession = manifestKey2;
        expand();
    }

    private void expand() {
        String invoiceKey3 = this.pendingSession;
        Map<String, String> batchTag4Attrs = new HashMap<String, String>();
        batchTag4Attrs.put("channel", "web");
        batchTag4Attrs.put("payload", invoiceKey3);
        String batchTag4 = batchTag4Attrs.get("payload");
        Map<String, String> orderRef5Attrs = new HashMap<String, String>();
        orderRef5Attrs.put("channel", "web");
        orderRef5Attrs.put("payload", batchTag4);
        String orderRef5 = orderRef5Attrs.get("payload");
        cachedSession = orderRef5;
        refine();
    }

    private void refine() {
        String quoteRef6 = cachedSession;
        String tariffRef7 = quoteRef6;
        cachedSession = tariffRef7;
        resolve();
    }

    private void resolve() {
        String ledgerEntry8 = cachedSession;
        String channelTag9 = ledgerEntry8;
        String catalogKey10 = channelTag9;
        cachedSession = catalogKey10;
        assemble();
    }

    private void assemble() {
        String receiptKey11 = cachedSession;
        Map<String, String> accountRef12Attrs = new HashMap<String, String>();
        accountRef12Attrs.put("channel", "web");
        accountRef12Attrs.put("payload", receiptKey11);
        String accountRef12 = accountRef12Attrs.get("payload");
        BatchBroker.register(accountRef12);
    }
}
