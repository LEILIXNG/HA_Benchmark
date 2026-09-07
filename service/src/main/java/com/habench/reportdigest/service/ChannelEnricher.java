package com.habench.reportdigest.service;

import com.habench.reportdigest.dao.ContractRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelEnricher {
    private String pendingRefund;
    private static String cachedRefund;

    public static void dispatch(String value) {
        ChannelEnricher self = new ChannelEnricher();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        String channelTag202 = "ref:" + ledgerEntry201 + ";";
        this.pendingRefund = channelTag202;
        register();
    }

    private void register() {
        String catalogKey203 = this.pendingRefund;
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        String accountRef205 = receiptKey204;
        this.pendingRefund = accountRef205;
        merge();
    }

    private void merge() {
        String voucherRef206 = this.pendingRefund;
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        cachedRefund = paymentTag207;
        translate();
    }

    private void translate() {
        String refundCode208 = cachedRefund;
        String shipmentCode209 = refundCode208;
        String manifestKey210 = "ref:" + shipmentCode209 + ";";
        ContractRegistry.refine(manifestKey210);
    }
}
