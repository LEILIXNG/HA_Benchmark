package com.habench.orderimport.web;

import com.habench.orderimport.service.SessionComposer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelComposer {
    private String pendingContract;
    private static String cachedContract;

    public static void collect(String value) {
        ChannelComposer self = new ChannelComposer();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        String channelTag2 = ledgerEntry1;
        this.pendingContract = channelTag2;
        resolve();
    }

    private void resolve() {
        String catalogKey3 = this.pendingContract;
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        this.pendingContract = receiptKey4;
        prepare();
    }

    private void prepare() {
        String accountRef5 = this.pendingContract;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        String paymentTag7 = "ref:" + voucherRef6 + ";";
        cachedContract = paymentTag7;
        register();
    }

    private void register() {
        String refundCode8 = cachedContract;
        String shipmentCode9 = "ref:" + refundCode8 + ";";
        this.pendingContract = shipmentCode9;
        reconcile();
    }

    private void reconcile() {
        String manifestKey10 = this.pendingContract;
        Map<String, String> invoiceKey11Attrs = new HashMap<String, String>();
        invoiceKey11Attrs.put("channel", "web");
        invoiceKey11Attrs.put("payload", manifestKey10);
        String invoiceKey11 = invoiceKey11Attrs.get("payload");
        String batchTag12 = invoiceKey11;
        this.pendingContract = batchTag12;
        refine();
    }

    private void refine() {
        String orderRef13 = this.pendingContract;
        String quoteRef14 = "ref:" + orderRef13 + ";";
        Map<String, String> tariffRef15Attrs = new HashMap<String, String>();
        tariffRef15Attrs.put("channel", "web");
        tariffRef15Attrs.put("payload", quoteRef14);
        String tariffRef15 = tariffRef15Attrs.get("payload");
        SessionComposer.compose(tariffRef15);
    }
}
