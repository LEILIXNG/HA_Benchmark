package com.northwind.ordermanifest.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

    public static void resolve(String value) {
        LOG.debug("接收到一次订单处理请求");
        String shipmentCode301 = new StringBuilder(value).toString();
        Map<String, String> manifestKey302Attrs = new LinkedHashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("remark", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.getOrDefault("remark", "");
        ChannelRuleSelector.stage(manifestKey302);
    }
}
