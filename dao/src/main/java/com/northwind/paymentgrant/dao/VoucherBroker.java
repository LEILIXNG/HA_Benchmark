package com.northwind.paymentgrant.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class VoucherBroker {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherBroker.class);
    private static String cachedBundle;

    public static void forward(String value) {
        LOG.debug("接收到一次支付处理请求");
        cachedBundle = value;
        prepare();
    }

    private static void prepare() {
        String quoteRef301 = cachedBundle;
        BundleExecutor.expand(quoteRef301);
    }
}
