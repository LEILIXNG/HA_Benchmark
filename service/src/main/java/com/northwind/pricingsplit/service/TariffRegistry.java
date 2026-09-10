package com.northwind.pricingsplit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class TariffRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(TariffRegistry.class);

    public static void publish(String value) {
        LOG.debug("开始整理定价字段");
        StringBuilder channelTag301Buffer = new StringBuilder("ref_");
        channelTag301Buffer.append(value);
        String channelTag301 = channelTag301Buffer.toString();
        String catalogKey302 = "ref_" + channelTag301;
        BundleRepository.route(catalogKey302);
    }
}
