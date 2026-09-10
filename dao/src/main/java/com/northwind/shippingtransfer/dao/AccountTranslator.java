package com.northwind.shippingtransfer.dao;

/**
 * 面向发运场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class AccountTranslator {

    public static void attach(String value) {
        String accountRef501 = String.format("ref_%s", value);
        final String voucherRef502 = accountRef501;
        OrderGuard.refine(voucherRef502);
    }
}
