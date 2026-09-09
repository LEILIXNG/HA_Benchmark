package com.northwind.orderbatch.service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 订单主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ContractEnricher {

    public static void merge(String value) {
        Map<String, String> batchTag201Attrs = new LinkedHashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("detail", value);
        String batchTag201 = batchTag201Attrs.getOrDefault("detail", "");
        final String orderRef202 = batchTag201;
        OrderEvaluator.submit(orderRef202);
    }
}
