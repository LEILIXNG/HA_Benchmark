package com.northwind.billingnotice.web;

import com.northwind.billingnotice.service.TariffRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderTranslator.class);

    public static void register(String value) {
        LOG.debug("开始整理账务字段");
        String batchTag101 = new StringBuilder(value).toString();
        TariffRouter.collect(batchTag101);
    }
}
