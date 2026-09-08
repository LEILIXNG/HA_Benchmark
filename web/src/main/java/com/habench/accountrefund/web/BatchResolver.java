package com.habench.accountrefund.web;

import com.habench.accountrefund.service.ChannelAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BatchResolver {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void compose(String value) {
        BatchResolver self = new BatchResolver();
        self.refine(value);
    }

    private void refine(String value) {
        String quoteRef1 = value;
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        cachedVoucher = tariffRef2;
        route();
    }

    private void route() {
        String ledgerEntry3 = cachedVoucher;
        String channelTag4 = ledgerEntry3;
        this.pendingVoucher = channelTag4;
        normalize();
    }

    private void normalize() {
        String catalogKey5 = this.pendingVoucher;
        String receiptKey6 = catalogKey5;
        cachedVoucher = receiptKey6;
        collect();
    }

    private void collect() {
        String accountRef7 = cachedVoucher;
        String voucherRef8 = accountRef7;
        this.pendingVoucher = voucherRef8;
        register();
    }

    private void register() {
        String paymentTag9 = this.pendingVoucher;
        String refundCode10 = paymentTag9;
        this.pendingVoucher = refundCode10;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode11 = this.pendingVoucher;
        String manifestKey12 = shipmentCode11;
        String invoiceKey13 = "ref:" + manifestKey12 + ";";
        ChannelAdapter.stage(invoiceKey13);
    }
}
