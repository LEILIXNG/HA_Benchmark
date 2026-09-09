package com.northwind.catalogexport.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelResolver.class);

    public static void publish(String value) {
        LOG.debug("商品流程转下一环节");
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("detail", value);
        String invoiceKey201 = invoiceKey201Attrs.get("detail");
        ShipmentGateway.attach(invoiceKey201);
    }
}
