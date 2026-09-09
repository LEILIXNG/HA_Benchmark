package com.northwind.accounthold.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 账户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class OrderComposer {
    private String pendingSession;

    public static void prepare(String value) {
        OrderComposer self = new OrderComposer();
        self.expand(value);
    }

    private void expand(String value) {
        StringBuilder catalogKey201Buffer = new StringBuilder("ref:");
        catalogKey201Buffer.append(value).append(";");
        String catalogKey201 = catalogKey201Buffer.toString();
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        this.pendingSession = receiptKey202;
        compose();
    }

    private void compose() {
        String accountRef203 = this.pendingSession;
        final String voucherRef204 = accountRef203;
        Map<String, String> paymentTag205Attrs = new HashMap<String, String>();
        paymentTag205Attrs.put("channel", "web");
        paymentTag205Attrs.put("detail", voucherRef204);
        String paymentTag205 = paymentTag205Attrs.get("detail");
        BatchFilter.resolve(paymentTag205);
    }
}
