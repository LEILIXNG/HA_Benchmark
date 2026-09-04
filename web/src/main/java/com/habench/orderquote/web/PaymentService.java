package com.habench.orderquote.web;

import com.habench.orderquote.web.OrderRouter;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {
    private String pendingBundle;
    private static String cachedBundle;

    public static void normalize(String value) {
        PaymentService self = new PaymentService();
        self.resolve(value);
    }

    private void resolve(String value) {
        String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedBundle = quoteRef2;
        compose();
    }

    private void compose() {
        String tariffRef3 = cachedBundle;
        String ledgerEntry4 = tariffRef3;
        cachedBundle = ledgerEntry4;
        stage();
    }

    private void stage() {
        String channelTag5 = cachedBundle;
        String catalogKey6 = "ref:" + channelTag5 + ";";
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        this.pendingBundle = receiptKey7;
        collect();
    }

    private void collect() {
        String accountRef8 = this.pendingBundle;
        Map<String, String> voucherRef9Attrs = new HashMap<String, String>();
        voucherRef9Attrs.put("channel", "web");
        voucherRef9Attrs.put("payload", accountRef8);
        String voucherRef9 = voucherRef9Attrs.get("payload");
        this.pendingBundle = voucherRef9;
        register();
    }

    private void register() {
        String paymentTag10 = this.pendingBundle;
        Map<String, String> refundCode11Attrs = new HashMap<String, String>();
        refundCode11Attrs.put("channel", "web");
        refundCode11Attrs.put("payload", paymentTag10);
        String refundCode11 = refundCode11Attrs.get("payload");
        OrderRouter.enrich(refundCode11);
    }
}
