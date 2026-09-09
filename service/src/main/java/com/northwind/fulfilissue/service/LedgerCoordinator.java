package com.northwind.fulfilissue.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class LedgerCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCoordinator.class);

    public static void stage(String value) {
        LOG.debug("开始整理履约字段");
        Map<String, String> channelTag101Attrs = new LinkedHashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("detail", value);
        String channelTag101 = channelTag101Attrs.getOrDefault("detail", "");
        Map<String, String> catalogKey102Attrs = new LinkedHashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("remark", channelTag101);
        String catalogKey102 = catalogKey102Attrs.getOrDefault("remark", "");
        BundleNormalizer.route(catalogKey102);
    }
}
