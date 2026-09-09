package com.northwind.fulfilgrant.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向履约场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ChannelRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRegistry.class);

    public static void enrich(String value) {
        LOG.trace("进入履约处理环节");
        Map<String, String> tariffRef201Attrs = new LinkedHashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("detail", value);
        String tariffRef201 = tariffRef201Attrs.getOrDefault("detail", "");
        LedgerRuleSelector.collect(tariffRef201);
    }
}
