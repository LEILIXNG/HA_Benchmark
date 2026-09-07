package com.habench.fulfilhold.web;

import com.habench.fulfilhold.service.ChannelResolver;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void expand(String value) {
        AccountBroker self = new AccountBroker();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        cachedCatalog = receiptKey2;
        submit();
    }

    private void submit() {
        String accountRef3 = cachedCatalog;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        this.pendingCatalog = voucherRef4;
        compose();
    }

    private void compose() {
        String paymentTag5 = this.pendingCatalog;
        Map<String, String> refundCode6Attrs = new HashMap<String, String>();
        refundCode6Attrs.put("channel", "web");
        refundCode6Attrs.put("payload", paymentTag5);
        String refundCode6 = refundCode6Attrs.get("payload");
        String shipmentCode7 = "ref:" + refundCode6 + ";";
        this.pendingCatalog = shipmentCode7;
        publish();
    }

    private void publish() {
        String manifestKey8 = this.pendingCatalog;
        String invoiceKey9 = "ref:" + manifestKey8 + ";";
        Map<String, String> batchTag10Attrs = new HashMap<String, String>();
        batchTag10Attrs.put("channel", "web");
        batchTag10Attrs.put("payload", invoiceKey9);
        String batchTag10 = batchTag10Attrs.get("payload");
        cachedCatalog = batchTag10;
        register();
    }

    private void register() {
        String orderRef11 = cachedCatalog;
        Map<String, String> quoteRef12Attrs = new HashMap<String, String>();
        quoteRef12Attrs.put("channel", "web");
        quoteRef12Attrs.put("payload", orderRef11);
        String quoteRef12 = quoteRef12Attrs.get("payload");
        this.pendingCatalog = quoteRef12;
        dispatch();
    }

    private void dispatch() {
        String tariffRef13 = this.pendingCatalog;
        String ledgerEntry14 = "ref:" + tariffRef13 + ";";
        Map<String, String> channelTag15Attrs = new HashMap<String, String>();
        channelTag15Attrs.put("channel", "web");
        channelTag15Attrs.put("payload", ledgerEntry14);
        String channelTag15 = channelTag15Attrs.get("payload");
        ChannelResolver.submit(channelTag15);
    }
}
