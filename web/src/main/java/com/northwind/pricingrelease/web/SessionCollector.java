package com.northwind.pricingrelease.web;

import com.northwind.pricingrelease.service.BatchCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 定价明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class SessionCollector {
    private String pendingQuote;

    public static void prepare(String value) {
        SessionCollector self = new SessionCollector();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        final String catalogKey1 = value;
        List<String> receiptKey2Attrs = new ArrayList<String>();
        receiptKey2Attrs.add("web");
        receiptKey2Attrs.add(catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get(1);
        this.pendingQuote = receiptKey2;
        reconcile();
    }

    private void reconcile() {
        String accountRef3 = this.pendingQuote;
        List<String> voucherRef4Attrs = new ArrayList<String>();
        voucherRef4Attrs.add("web");
        voucherRef4Attrs.add(accountRef3);
        String voucherRef4 = voucherRef4Attrs.get(1);
        Map<String, String> paymentTag5Attrs = new LinkedHashMap<String, String>();
        paymentTag5Attrs.put("channel", "web");
        paymentTag5Attrs.put("detail", voucherRef4);
        String paymentTag5 = paymentTag5Attrs.getOrDefault("detail", "");
        BatchCollector.publish(paymentTag5);
    }
}
