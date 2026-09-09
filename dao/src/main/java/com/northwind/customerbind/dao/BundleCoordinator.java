package com.northwind.customerbind.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);

    public static void stage(String value) {
        LOG.debug("接收到一次客户处理请求");
        String manifestKey301 = value;
        BatchAssembler.collect(manifestKey301);
    }
}
