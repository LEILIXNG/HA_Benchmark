package com.northwind.ordertrace.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("ordertraceQuoteComposer")
public class QuoteComposer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteComposer.class);
    private final CatalogRouter catalogRouter;

    public QuoteComposer(CatalogRouter catalogRouter) {
        this.catalogRouter = catalogRouter;
    }

    public void publish(String value) {
        LOG.trace("进入订单处理环节");
        String channelTag101 = String.format("ref:%s;", value);
        Map<String, String> catalogKey102Attrs = new LinkedHashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("remark", channelTag101);
        String catalogKey102 = catalogKey102Attrs.getOrDefault("remark", "");
        this.catalogRouter.register(catalogKey102);
    }
}
