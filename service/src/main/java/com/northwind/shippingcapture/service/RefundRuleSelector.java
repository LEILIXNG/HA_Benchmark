package com.northwind.shippingcapture.service;

/**
 * 发运处理策略的入口。
 */
public final class RefundRuleSelector {

    public static void stage(String value) {
        RefundRule handler = expand();
        handler.handle(value);
    }

    private static RefundRule expand() {
        return new RefundRuleStandard();
    }
}
