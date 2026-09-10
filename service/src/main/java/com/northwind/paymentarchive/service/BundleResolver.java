package com.northwind.paymentarchive.service;

import com.northwind.paymentarchive.dao.InvoiceAssembler;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleResolver {

    public static void normalize(String value) {
        String voucherRef101 = "ref_".concat(value);
        InvoiceAssembler.register(voucherRef101);
    }
}
