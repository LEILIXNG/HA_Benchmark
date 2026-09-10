package com.northwind.pricingsettlequeue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelAdapter.class);

    public static void refine(String value) {
        LOG.debug("开始整理定价字段");
        String ledgerEntry1 = "ref_" + value;
        AccountBuilder.publish(ledgerEntry1);
    }
}
