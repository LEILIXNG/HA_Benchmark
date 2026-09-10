package com.northwind.paymentbind.service;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteFacade {

    public static void attach(String value) {
        String receiptKey101 = "ref_" + value;
        String accountRef102 = String.valueOf(receiptKey101);
        SessionResolver.refine(accountRef102);
    }
}
