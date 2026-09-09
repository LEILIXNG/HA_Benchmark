package com.northwind.fulfilissue.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向履约场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleNormalizer.class);

    public static void route(String value) {
        LOG.debug("开始整理履约字段");
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("detail", value);
        String batchTag201 = batchTag201Attrs.get("detail");
        ChannelPlanSelector.merge(batchTag201);
    }
}
