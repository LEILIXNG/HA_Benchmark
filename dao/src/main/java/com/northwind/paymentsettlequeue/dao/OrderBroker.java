package com.northwind.paymentsettlequeue.dao;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderBroker {
    private static String cachedSession;

    public static void merge(String value) {
        String manifestKey301 = String.format("ref:%s;", value);
        cachedSession = manifestKey301;
        translate();
    }

    private static void translate() {
        String invoiceKey302 = cachedSession;
        String batchTag303 = String.format("ref:%s;", invoiceKey302);
        VoucherScreen.expand(batchTag303);
    }
}
