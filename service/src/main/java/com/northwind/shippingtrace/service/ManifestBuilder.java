package com.northwind.shippingtrace.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ManifestBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestBuilder.class);

    public static void forward(String value) {
        LOG.trace("进入发运处理环节");
        String tariffRef101 = "ref_".concat(value);
        PaymentComposer.forward(tariffRef101);
    }
}
