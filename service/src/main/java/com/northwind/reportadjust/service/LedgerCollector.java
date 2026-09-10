package com.northwind.reportadjust.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class LedgerCollector {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCollector.class);
    private static String cachedContract;

    public static void route(String value) {
        LOG.debug("开始整理报表字段");
        String orderRef301 = value;
        cachedContract = orderRef301;
        resolve();
    }

    private static void resolve() {
        String quoteRef302 = cachedContract;
        Map<String, String> tariffRef303Attrs = new LinkedHashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("note", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.getOrDefault("note", "");
        String ledgerEntry304 = new StringBuilder(tariffRef303).toString();
        ChannelBroker.translate(ledgerEntry304);
    }
}
