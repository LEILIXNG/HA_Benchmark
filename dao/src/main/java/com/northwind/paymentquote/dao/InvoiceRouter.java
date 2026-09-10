package com.northwind.paymentquote.dao;

/**
 * 支付受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceRouter {

    public static void submit(String value) {
        String invoiceKey301 = value;
        String batchTag302 = String.format("ref_%s", invoiceKey301);
        RefundAssembler.normalize(batchTag302);
    }
}
