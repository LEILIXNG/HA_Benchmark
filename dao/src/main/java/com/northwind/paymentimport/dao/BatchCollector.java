package com.northwind.paymentimport.dao;

/**
 * 面向支付场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BatchCollector {

    public static void dispatch(String value) {
        StringBuilder accountRef201Buffer = new StringBuilder("ref_");
        accountRef201Buffer.append(value);
        String accountRef201 = accountRef201Buffer.toString();
        LedgerFetcher.prepare(accountRef201);
    }
}
