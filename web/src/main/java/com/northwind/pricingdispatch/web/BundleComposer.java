package com.northwind.pricingdispatch.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundleComposer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleComposer.class);
    private String pendingAccount;

    public static void resolve(String value) {
        LOG.debug("接收到一次定价处理请求");
        BundleComposer self = new BundleComposer();
        self.refine(value);
    }

    private void refine(String value) {
        String accountRef101 = "ref:".concat(value).concat(";");
        this.pendingAccount = accountRef101;
        normalize();
    }

    private void normalize() {
        String voucherRef102 = this.pendingAccount;
        Map<String, String> paymentTag103Attrs = new LinkedHashMap<String, String>();
        paymentTag103Attrs.put("channel", "web");
        paymentTag103Attrs.put("note", voucherRef102);
        String paymentTag103 = paymentTag103Attrs.getOrDefault("note", "");
        VoucherResolver.attach(paymentTag103);
    }
}
