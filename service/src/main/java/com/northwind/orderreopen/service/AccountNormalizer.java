package com.northwind.orderreopen.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountNormalizer.class);
    private static String cachedLedger;

    public static void merge(String value) {
        LOG.debug("接收到一次订单处理请求");
        StringBuilder quoteRef201Buffer = new StringBuilder("ref:");
        quoteRef201Buffer.append(value).append(";");
        String quoteRef201 = quoteRef201Buffer.toString();
        cachedLedger = quoteRef201;
        collect();
    }

    private static void collect() {
        String tariffRef202 = cachedLedger;
        String ledgerEntry203 = new StringBuilder(tariffRef202).toString();
        Map<String, String> channelTag204Attrs = new LinkedHashMap<String, String>();
        channelTag204Attrs.put("channel", "web");
        channelTag204Attrs.put("reference", ledgerEntry203);
        String channelTag204 = channelTag204Attrs.getOrDefault("reference", "");
        LedgerFetcher.expand(channelTag204);
    }
}
