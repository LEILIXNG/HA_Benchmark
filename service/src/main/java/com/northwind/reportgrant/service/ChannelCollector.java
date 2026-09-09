package com.northwind.reportgrant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCollector.class);
    private static String cachedOrder;

    public static void compose(String value) {
        LOG.debug("接收到一次报表处理请求");
        StringBuilder quoteRef301Buffer = new StringBuilder("ref:");
        quoteRef301Buffer.append(value).append(";");
        String quoteRef301 = quoteRef301Buffer.toString();
        String tariffRef302 = new StringBuilder(quoteRef301).toString();
        cachedOrder = tariffRef302;
        register();
    }

    private static void register() {
        String ledgerEntry303 = cachedOrder;
        String channelTag304 = String.format("ref:%s;", ledgerEntry303);
        String catalogKey305 = "ref:".concat(channelTag304).concat(";");
        OrderLoader.assemble(catalogKey305);
    }
}
