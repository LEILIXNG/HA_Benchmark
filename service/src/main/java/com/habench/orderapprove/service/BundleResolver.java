package com.habench.orderapprove.service;

import com.habench.orderapprove.dao.ChannelFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleResolver {
    private String pendingRefund;

    public static void attach(String value) {
        BundleResolver self = new BundleResolver();
        self.register(value);
    }

    private void register(String value) {
        String catalogKey101 = value;
        String receiptKey102 = "ref:" + catalogKey101 + ";";
        this.pendingRefund = receiptKey102;
        merge();
    }

    private void merge() {
        String accountRef103 = this.pendingRefund;
        Map<String, String> voucherRef104Attrs = new HashMap<String, String>();
        voucherRef104Attrs.put("channel", "web");
        voucherRef104Attrs.put("payload", accountRef103);
        String voucherRef104 = voucherRef104Attrs.get("payload");
        ChannelFacade.merge(voucherRef104);
    }
}
