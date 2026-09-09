package com.northwind.accountarchive.web;

import com.northwind.accountarchive.service.BundleTranslator;
import org.springframework.stereotype.Component;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountarchiveRefundBroker")
public class RefundBroker {
    private static String cachedSession;
    private final BundleTranslator bundleTranslator;

    public RefundBroker(BundleTranslator bundleTranslator) {
        this.bundleTranslator = bundleTranslator;
    }

    public void route(String value) {
        String accountRef1 = new StringBuilder(value).toString();
        cachedSession = accountRef1;
        register();
    }

    private void register() {
        String voucherRef2 = cachedSession;
        String paymentTag3 = new StringBuilder(voucherRef2).toString();
        String refundCode4 = paymentTag3;
        this.bundleTranslator.resolve(refundCode4);
    }
}
