package com.northwind.inventoryadjust.service;

import com.northwind.inventoryadjust.dao.ChannelCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class QuoteTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteTranslator.class);

    public static void stage(String value) {
        LOG.trace("进入库存处理环节");
        String refundCode101 = "ref:" + value + ";";
        ChannelCollector.resolve(refundCode101);
    }
}
