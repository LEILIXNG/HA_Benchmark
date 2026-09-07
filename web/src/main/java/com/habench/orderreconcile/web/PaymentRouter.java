package com.habench.orderreconcile.web;

import com.habench.orderreconcile.web.PaymentGuard;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void expand(String value) {
        PaymentRouter self = new PaymentRouter();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        cachedCatalog = tariffRef1;
        submit();
    }

    private void submit() {
        String ledgerEntry2 = cachedCatalog;
        String channelTag3 = "ref:" + ledgerEntry2 + ";";
        cachedCatalog = channelTag3;
        stage();
    }

    private void stage() {
        String catalogKey4 = cachedCatalog;
        Map<String, String> receiptKey5Attrs = new HashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("payload", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get("payload");
        cachedCatalog = receiptKey5;
        collect();
    }

    private void collect() {
        String accountRef6 = cachedCatalog;
        Map<String, String> voucherRef7Attrs = new HashMap<String, String>();
        voucherRef7Attrs.put("channel", "web");
        voucherRef7Attrs.put("payload", accountRef6);
        String voucherRef7 = voucherRef7Attrs.get("payload");
        this.pendingCatalog = voucherRef7;
        forward();
    }

    private void forward() {
        String paymentTag8 = this.pendingCatalog;
        String refundCode9 = paymentTag8;
        PaymentGuard.assemble(refundCode9);
    }
}
