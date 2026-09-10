package com.northwind.paymentledger.dao;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class PaymentCollector {

    public static void enrich(String value) {
        String paymentTag401 = "ref_".concat(value);
        String refundCode402 = String.format("ref_%s", paymentTag401);
        TariffLoader.translate(refundCode402);
    }
}
