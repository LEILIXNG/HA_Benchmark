package com.northwind.customerlookup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);

    public static void refine(String value) {
        LOG.trace("进入客户处理环节");
        final String receiptKey101 = value;
        AccountFetcher.compose(receiptKey101);
    }
}
