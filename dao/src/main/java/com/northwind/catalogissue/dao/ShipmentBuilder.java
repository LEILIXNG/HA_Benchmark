package com.northwind.catalogissue.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentBuilder.class);

    public static void dispatch(String value) {
        LOG.debug("商品流程转下一环节");
        final String paymentTag301 = value;
        String refundCode302 = new StringBuilder(paymentTag301).toString();
        CatalogEnricher.dispatch(refundCode302);
    }
}
