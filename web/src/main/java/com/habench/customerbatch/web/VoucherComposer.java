package com.habench.customerbatch.web;

import com.habench.customerbatch.service.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {
    private String pendingBatch;
    private static String cachedBatch;

    public static void normalize(String value) {
        VoucherComposer self = new VoucherComposer();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        cachedBatch = tariffRef102;
        assemble();
    }

    private void assemble() {
        String ledgerEntry103 = cachedBatch;
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        String catalogKey105 = "ref:" + channelTag104 + ";";
        cachedBatch = catalogKey105;
        submit();
    }

    private void submit() {
        String receiptKey106 = cachedBatch;
        String accountRef107 = receiptKey106;
        this.pendingBatch = accountRef107;
        translate();
    }

    private void translate() {
        String voucherRef108 = this.pendingBatch;
        Map<String, String> paymentTag109Attrs = new HashMap<String, String>();
        paymentTag109Attrs.put("channel", "web");
        paymentTag109Attrs.put("payload", voucherRef108);
        String paymentTag109 = paymentTag109Attrs.get("payload");
        String refundCode110 = "ref:" + paymentTag109 + ";";
        ShipmentBuilder.resolve(refundCode110);
    }
}
