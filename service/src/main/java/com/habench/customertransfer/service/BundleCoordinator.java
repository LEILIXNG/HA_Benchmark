package com.habench.customertransfer.service;

import com.habench.customertransfer.service.VoucherBroker;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private String pendingAccount;
    private static String cachedAccount;

    public static void publish(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.stage(value);
    }

    private void stage(String value) {
        String quoteRef201 = value;
        this.pendingAccount = quoteRef201;
        normalize();
    }

    private void normalize() {
        String tariffRef202 = this.pendingAccount;
        Map<String, String> ledgerEntry203Attrs = new HashMap<String, String>();
        ledgerEntry203Attrs.put("channel", "web");
        ledgerEntry203Attrs.put("payload", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.get("payload");
        cachedAccount = ledgerEntry203;
        submit();
    }

    private void submit() {
        String channelTag204 = cachedAccount;
        Map<String, String> catalogKey205Attrs = new HashMap<String, String>();
        catalogKey205Attrs.put("channel", "web");
        catalogKey205Attrs.put("payload", channelTag204);
        String catalogKey205 = catalogKey205Attrs.get("payload");
        cachedAccount = catalogKey205;
        assemble();
    }

    private void assemble() {
        String receiptKey206 = cachedAccount;
        String accountRef207 = "ref:" + receiptKey206 + ";";
        VoucherBroker.expand(accountRef207);
    }
}
