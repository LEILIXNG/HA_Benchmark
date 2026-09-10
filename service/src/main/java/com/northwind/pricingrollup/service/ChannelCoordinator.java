package com.northwind.pricingrollup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCoordinator.class);

    public static void prepare(String value) {
        LOG.trace("进入定价处理环节");
        String batchTag301 = String.format("ref_%s", value);
        ChannelGateway.route(batchTag301);
    }
}
