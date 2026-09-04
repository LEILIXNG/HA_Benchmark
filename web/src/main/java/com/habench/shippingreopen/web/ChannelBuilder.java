package com.habench.shippingreopen.web;

import com.habench.shippingreopen.web.ManifestNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {
    private String pendingQuote;

    public static void stage(String value) {
        ChannelBuilder self = new ChannelBuilder();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        String voucherRef2 = "ref:" + accountRef1 + ";";
        this.pendingQuote = voucherRef2;
        merge();
    }

    private void merge() {
        String paymentTag3 = this.pendingQuote;
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("payload", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("payload");
        ManifestNormalizer.enrich(refundCode4);
    }
}
