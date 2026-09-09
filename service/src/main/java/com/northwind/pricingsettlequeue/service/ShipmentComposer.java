package com.northwind.pricingsettlequeue.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentComposer.class);

    public static void forward(String value) {
        LOG.debug("开始整理定价字段");
        String ledgerEntry301 = String.valueOf(value);
        String channelTag302 = ledgerEntry301;
        CatalogRuleSelector.expand(channelTag302);
    }
}
