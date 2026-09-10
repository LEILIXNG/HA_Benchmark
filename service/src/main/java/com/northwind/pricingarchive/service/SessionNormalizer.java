package com.northwind.pricingarchive.service;

import com.northwind.pricingarchive.dao.BatchResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向定价场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class SessionNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(SessionNormalizer.class);

    public static void merge(String value) {
        LOG.debug("开始整理定价字段");
        StringBuilder refundCode201Buffer = new StringBuilder("ref_");
        refundCode201Buffer.append(value);
        String refundCode201 = refundCode201Buffer.toString();
        String shipmentCode202 = String.valueOf(refundCode201);
        BatchResolver.dispatch(shipmentCode202);
    }
}
