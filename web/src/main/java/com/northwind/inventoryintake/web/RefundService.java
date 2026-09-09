package com.northwind.inventoryintake.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向库存场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class RefundService {
    private static final Logger LOG = LoggerFactory.getLogger(RefundService.class);

    public static void resolve(String value) {
        LOG.debug("库存流程转下一环节");
        final String receiptKey101 = value;
        String accountRef102 = "ref:" + receiptKey101 + ";";
        RefundEnricher.stage(accountRef102);
    }
}
