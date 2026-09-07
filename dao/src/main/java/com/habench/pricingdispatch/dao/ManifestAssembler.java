package com.habench.pricingdispatch.dao;

import com.habench.pricingdispatch.dao.AccountEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAssembler {
    private String pendingAccount;
    private static String cachedAccount;

    public static void refine(String value) {
        ManifestAssembler self = new ManifestAssembler();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> accountRef401Attrs = new HashMap<String, String>();
        accountRef401Attrs.put("channel", "web");
        accountRef401Attrs.put("payload", value);
        String accountRef401 = accountRef401Attrs.get("payload");
        String voucherRef402 = accountRef401;
        cachedAccount = voucherRef402;
        publish();
    }

    private void publish() {
        String paymentTag403 = cachedAccount;
        String refundCode404 = "ref:" + paymentTag403 + ";";
        String shipmentCode405 = refundCode404;
        cachedAccount = shipmentCode405;
        prepare();
    }

    private void prepare() {
        String manifestKey406 = cachedAccount;
        String invoiceKey407 = manifestKey406;
        this.pendingAccount = invoiceKey407;
        attach();
    }

    private void attach() {
        String batchTag408 = this.pendingAccount;
        Map<String, String> orderRef409Attrs = new HashMap<String, String>();
        orderRef409Attrs.put("channel", "web");
        orderRef409Attrs.put("payload", batchTag408);
        String orderRef409 = orderRef409Attrs.get("payload");
        AccountEvaluator.normalize(orderRef409);
    }
}
