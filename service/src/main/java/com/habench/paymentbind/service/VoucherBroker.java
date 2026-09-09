package com.habench.paymentbind.service;

import com.habench.paymentbind.dao.ReceiptRegistry;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {
    private String pendingSession;
    private static String cachedSession;

    public static void submit(String value) {
        VoucherBroker self = new VoucherBroker();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        String manifestKey302 = shipmentCode301;
        this.pendingSession = manifestKey302;
        refine();
    }

    private void refine() {
        String invoiceKey303 = this.pendingSession;
        String batchTag304 = "ref:" + invoiceKey303 + ";";
        String orderRef305 = "ref:" + batchTag304 + ";";
        this.pendingSession = orderRef305;
        prepare();
    }

    private void prepare() {
        String quoteRef306 = this.pendingSession;
        Map<String, String> tariffRef307Attrs = new HashMap<String, String>();
        tariffRef307Attrs.put("channel", "web");
        tariffRef307Attrs.put("payload", quoteRef306);
        String tariffRef307 = tariffRef307Attrs.get("payload");
        Map<String, String> ledgerEntry308Attrs = new HashMap<String, String>();
        ledgerEntry308Attrs.put("channel", "web");
        ledgerEntry308Attrs.put("payload", tariffRef307);
        String ledgerEntry308 = ledgerEntry308Attrs.get("payload");
        cachedSession = ledgerEntry308;
        expand();
    }

    private void expand() {
        String channelTag309 = cachedSession;
        Map<String, String> catalogKey310Attrs = new HashMap<String, String>();
        catalogKey310Attrs.put("channel", "web");
        catalogKey310Attrs.put("payload", channelTag309);
        String catalogKey310 = catalogKey310Attrs.get("payload");
        Map<String, String> receiptKey311Attrs = new HashMap<String, String>();
        receiptKey311Attrs.put("channel", "web");
        receiptKey311Attrs.put("payload", catalogKey310);
        String receiptKey311 = receiptKey311Attrs.get("payload");
        ReceiptRegistry.prepare(receiptKey311);
    }
}
