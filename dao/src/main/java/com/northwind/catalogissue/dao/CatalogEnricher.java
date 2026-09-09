package com.northwind.catalogissue.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向商品场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogEnricher.class);

    public static void dispatch(String value) {
        LOG.debug("商品流程转下一环节");
        String channelTag401 = value;
        String catalogKey402 = "ref:".concat(channelTag401).concat(";");
        RefundEvaluator.prepare(catalogKey402);
    }
}
