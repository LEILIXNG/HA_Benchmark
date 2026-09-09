package com.northwind.shippingreconcile.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ReceiptResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptResolver.class);

    public static void dispatch(String value) {
        LOG.debug("开始整理发运字段");
        String tariffRef401 = String.format("ref:%s;", value);
        ContractNormalizer.attach(tariffRef401);
    }
}
