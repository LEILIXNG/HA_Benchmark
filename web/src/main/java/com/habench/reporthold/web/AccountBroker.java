package com.habench.reporthold.web;

import com.habench.reporthold.service.ChannelRegistry;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {
    private String pendingContract;
    private static String cachedContract;

    public static void merge(String value) {
        AccountBroker self = new AccountBroker();
        self.normalize(value);
    }

    private void normalize(String value) {
        String orderRef1 = value;
        String quoteRef2 = "ref:" + orderRef1 + ";";
        this.pendingContract = quoteRef2;
        route();
    }

    private void route() {
        String tariffRef3 = this.pendingContract;
        String ledgerEntry4 = tariffRef3;
        cachedContract = ledgerEntry4;
        register();
    }

    private void register() {
        String channelTag5 = cachedContract;
        String catalogKey6 = channelTag5;
        String receiptKey7 = catalogKey6;
        cachedContract = receiptKey7;
        translate();
    }

    private void translate() {
        String accountRef8 = cachedContract;
        String voucherRef9 = "ref:" + accountRef8 + ";";
        Map<String, String> paymentTag10Attrs = new HashMap<String, String>();
        paymentTag10Attrs.put("channel", "web");
        paymentTag10Attrs.put("payload", voucherRef9);
        String paymentTag10 = paymentTag10Attrs.get("payload");
        this.pendingContract = paymentTag10;
        dispatch();
    }

    private void dispatch() {
        String refundCode11 = this.pendingContract;
        String shipmentCode12 = "ref:" + refundCode11 + ";";
        String manifestKey13 = shipmentCode12;
        this.pendingContract = manifestKey13;
        compose();
    }

    private void compose() {
        String invoiceKey14 = this.pendingContract;
        String batchTag15 = invoiceKey14;
        this.pendingContract = batchTag15;
        collect();
    }

    private void collect() {
        String orderRef16 = this.pendingContract;
        String quoteRef17 = "ref:" + orderRef16 + ";";
        Map<String, String> tariffRef18Attrs = new HashMap<String, String>();
        tariffRef18Attrs.put("channel", "web");
        tariffRef18Attrs.put("payload", quoteRef17);
        String tariffRef18 = tariffRef18Attrs.get("payload");
        this.pendingContract = tariffRef18;
        refine();
    }

    private void refine() {
        String ledgerEntry19 = this.pendingContract;
        String channelTag20 = "ref:" + ledgerEntry19 + ";";
        Map<String, String> catalogKey21Attrs = new HashMap<String, String>();
        catalogKey21Attrs.put("channel", "web");
        catalogKey21Attrs.put("payload", channelTag20);
        String catalogKey21 = catalogKey21Attrs.get("payload");
        ChannelRegistry.stage(catalogKey21);
    }
}
