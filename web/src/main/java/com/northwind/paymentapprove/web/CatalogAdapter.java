package com.northwind.paymentapprove.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogAdapter {
    private String pendingAccount;

    public static void normalize(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        StringBuilder batchTag1Buffer = new StringBuilder("ref:");
        batchTag1Buffer.append(value).append(";");
        String batchTag1 = batchTag1Buffer.toString();
        this.pendingAccount = batchTag1;
        attach();
    }

    private void attach() {
        String orderRef2 = this.pendingAccount;
        String quoteRef3 = String.valueOf(orderRef2);
        this.pendingAccount = quoteRef3;
        resolve();
    }

    private void resolve() {
        String tariffRef4 = this.pendingAccount;
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("detail", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("detail");
        CatalogNormalizer.stage(ledgerEntry5);
    }
}
