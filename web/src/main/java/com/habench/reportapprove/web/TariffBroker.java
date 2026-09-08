package com.habench.reportapprove.web;

import com.habench.reportapprove.service.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private String pendingQuote;
    private static String cachedQuote;

    public static void stage(String value) {
        TariffBroker self = new TariffBroker();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        this.pendingQuote = channelTag101;
        refine();
    }

    private void refine() {
        String catalogKey102 = this.pendingQuote;
        String receiptKey103 = "ref:" + catalogKey102 + ";";
        String accountRef104 = receiptKey103;
        cachedQuote = accountRef104;
        publish();
    }

    private void publish() {
        String voucherRef105 = cachedQuote;
        String paymentTag106 = "ref:" + voucherRef105 + ";";
        String refundCode107 = "ref:" + paymentTag106 + ";";
        SessionBuilder.translate(refundCode107);
    }
}
