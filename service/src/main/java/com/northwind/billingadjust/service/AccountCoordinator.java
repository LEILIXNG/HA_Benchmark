package com.northwind.billingadjust.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class AccountCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(AccountCoordinator.class);
    private static String cachedLedger;

    public static void collect(String value) {
        LOG.trace("进入账务处理环节");
        String invoiceKey301 = "ref:" + value + ";";
        cachedLedger = invoiceKey301;
        enrich();
    }

    private static void enrich() {
        String batchTag302 = cachedLedger;
        Map<String, String> orderRef303Attrs = new LinkedHashMap<String, String>();
        orderRef303Attrs.put("channel", "web");
        orderRef303Attrs.put("note", batchTag302);
        String orderRef303 = orderRef303Attrs.getOrDefault("note", "");
        LedgerFetcher.enrich(orderRef303);
    }
}
