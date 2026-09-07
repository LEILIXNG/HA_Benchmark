package com.habench.accounttransfer.web;

import com.habench.accounttransfer.service.SessionAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRouter {
    private String pendingChannel;
    private static String cachedChannel;

    public static void publish(String value) {
        ReceiptRouter self = new ReceiptRouter();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        this.pendingChannel = quoteRef2;
        submit();
    }

    private void submit() {
        String tariffRef3 = this.pendingChannel;
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        this.pendingChannel = ledgerEntry4;
        translate();
    }

    private void translate() {
        String channelTag5 = this.pendingChannel;
        String catalogKey6 = "ref:" + channelTag5 + ";";
        String receiptKey7 = "ref:" + catalogKey6 + ";";
        cachedChannel = receiptKey7;
        dispatch();
    }

    private void dispatch() {
        String accountRef8 = cachedChannel;
        String voucherRef9 = "ref:" + accountRef8 + ";";
        this.pendingChannel = voucherRef9;
        assemble();
    }

    private void assemble() {
        String paymentTag10 = this.pendingChannel;
        Map<String, String> refundCode11Attrs = new HashMap<String, String>();
        refundCode11Attrs.put("channel", "web");
        refundCode11Attrs.put("payload", paymentTag10);
        String refundCode11 = refundCode11Attrs.get("payload");
        String shipmentCode12 = refundCode11;
        this.pendingChannel = shipmentCode12;
        route();
    }

    private void route() {
        String manifestKey13 = this.pendingChannel;
        String invoiceKey14 = "ref:" + manifestKey13 + ";";
        Map<String, String> batchTag15Attrs = new HashMap<String, String>();
        batchTag15Attrs.put("channel", "web");
        batchTag15Attrs.put("payload", invoiceKey14);
        String batchTag15 = batchTag15Attrs.get("payload");
        SessionAdapter.route(batchTag15);
    }
}
