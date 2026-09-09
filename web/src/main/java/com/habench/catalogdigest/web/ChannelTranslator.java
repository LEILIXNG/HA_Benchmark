package com.habench.catalogdigest.web;

import com.habench.catalogdigest.web.ManifestPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {
    private String pendingRefund;
    private static String cachedRefund;

    public static void forward(String value) {
        ChannelTranslator self = new ChannelTranslator();
        self.assemble(value);
    }

    private void assemble(String value) {
        String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedRefund = quoteRef2;
        merge();
    }

    private void merge() {
        String tariffRef3 = cachedRefund;
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        cachedRefund = channelTag5;
        normalize();
    }

    private void normalize() {
        String catalogKey6 = cachedRefund;
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        this.pendingRefund = receiptKey7;
        translate();
    }

    private void translate() {
        String accountRef8 = this.pendingRefund;
        String voucherRef9 = "ref:" + accountRef8 + ";";
        Map<String, String> paymentTag10Attrs = new HashMap<String, String>();
        paymentTag10Attrs.put("channel", "web");
        paymentTag10Attrs.put("payload", voucherRef9);
        String paymentTag10 = paymentTag10Attrs.get("payload");
        ManifestPolicySelector.submit(paymentTag10);
    }
}
