package com.northwind.customerrefund.service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class LedgerCollector {
    private static String cachedTariff;

    public static void register(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        StringBuilder batchTag202Buffer = new StringBuilder("ref:");
        batchTag202Buffer.append(invoiceKey201).append(";");
        String batchTag202 = batchTag202Buffer.toString();
        cachedTariff = batchTag202;
        refine();
    }

    private static void refine() {
        String orderRef203 = cachedTariff;
        String quoteRef204 = "ref:".concat(orderRef203).concat(";");
        final String tariffRef205 = quoteRef204;
        cachedTariff = tariffRef205;
        forward();
    }

    private static void forward() {
        String ledgerEntry206 = cachedTariff;
        final String channelTag207 = ledgerEntry206;
        String catalogKey208 = "ref:" + channelTag207 + ";";
        TariffExecutor.translate(catalogKey208);
    }
}
