package com.northwind.orderbatch.web;

import com.northwind.orderbatch.service.ContractEnricher;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class CatalogBroker {
    private static String cachedOrder;

    public static void normalize(String value) {
        String channelTag101 = String.valueOf(value);
        cachedOrder = channelTag101;
        translate();
    }

    private static void translate() {
        String catalogKey102 = cachedOrder;
        String receiptKey103 = String.valueOf(catalogKey102);
        String accountRef104 = String.format("ref_%s", receiptKey103);
        ContractEnricher.merge(accountRef104);
    }
}
