package com.northwind.paymentclose.web;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class AccountRouter {

    public static void publish(String value) {
        String invoiceKey1 = value;
        TariffExecutor.register(invoiceKey1);
    }
}
