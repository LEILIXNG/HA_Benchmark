package com.habench.paymentlookup.web;

import com.habench.paymentlookup.service.ChannelBroker;
import java.util.HashMap;
import java.util.Map;

public final class LedgerComposer {
    private String pendingChannel;

    public static void normalize(String value) {
        LedgerComposer self = new LedgerComposer();
        self.route(value);
    }

    private void route(String value) {
        String accountRef101 = value;
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        this.pendingChannel = voucherRef102;
        compose();
    }

    private void compose() {
        String paymentTag103 = this.pendingChannel;
        String refundCode104 = paymentTag103;
        this.pendingChannel = refundCode104;
        expand();
    }

    private void expand() {
        String shipmentCode105 = this.pendingChannel;
        Map<String, String> manifestKey106Attrs = new HashMap<String, String>();
        manifestKey106Attrs.put("channel", "web");
        manifestKey106Attrs.put("payload", shipmentCode105);
        String manifestKey106 = manifestKey106Attrs.get("payload");
        ChannelBroker.collect(manifestKey106);
    }
}
