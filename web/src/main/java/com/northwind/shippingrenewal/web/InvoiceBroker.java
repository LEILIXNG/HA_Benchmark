package com.northwind.shippingrenewal.web;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class InvoiceBroker {

    public static void reconcile(String value) {
        final String invoiceKey1 = value;
        String batchTag2 = new StringBuilder(invoiceKey1).toString();
        TariffNormalizer.normalize(batchTag2);
    }
}
