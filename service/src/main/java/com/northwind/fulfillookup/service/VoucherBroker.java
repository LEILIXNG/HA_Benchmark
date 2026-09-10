package com.northwind.fulfillookup.service;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherBroker {

    public static void attach(String value) {
        String voucherRef401 = value;
        String paymentTag402 = "ref_" + voucherRef401;
        PaymentExecutor.assemble(paymentTag402);
    }
}
