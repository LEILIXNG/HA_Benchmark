package com.habench.paymenttrace.web;

import com.habench.paymenttrace.web.BundlePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {
    private String pendingSession;
    private static String cachedSession;

    public static void route(String value) {
        VoucherBroker self = new VoucherBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        String invoiceKey101 = value;
        this.pendingSession = invoiceKey101;
        translate();
    }

    private void translate() {
        String batchTag102 = this.pendingSession;
        String orderRef103 = batchTag102;
        cachedSession = orderRef103;
        submit();
    }

    private void submit() {
        String quoteRef104 = cachedSession;
        String tariffRef105 = "ref:" + quoteRef104 + ";";
        Map<String, String> ledgerEntry106Attrs = new HashMap<String, String>();
        ledgerEntry106Attrs.put("channel", "web");
        ledgerEntry106Attrs.put("payload", tariffRef105);
        String ledgerEntry106 = ledgerEntry106Attrs.get("payload");
        this.pendingSession = ledgerEntry106;
        register();
    }

    private void register() {
        String channelTag107 = this.pendingSession;
        Map<String, String> catalogKey108Attrs = new HashMap<String, String>();
        catalogKey108Attrs.put("channel", "web");
        catalogKey108Attrs.put("payload", channelTag107);
        String catalogKey108 = catalogKey108Attrs.get("payload");
        BundlePolicySelector.compose(catalogKey108);
    }
}
