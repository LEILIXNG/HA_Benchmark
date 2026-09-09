package com.northwind.billingverify.web;

/**
 * 账务明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleBuilder {

    public static void translate(String value) {
        StringBuilder ledgerEntry101Buffer = new StringBuilder("ref:");
        ledgerEntry101Buffer.append(value).append(";");
        String ledgerEntry101 = ledgerEntry101Buffer.toString();
        final String channelTag102 = ledgerEntry101;
        InvoiceResolver.enrich(channelTag102);
    }
}
