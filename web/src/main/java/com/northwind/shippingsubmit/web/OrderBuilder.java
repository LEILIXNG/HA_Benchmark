package com.northwind.shippingsubmit.web;

import com.northwind.shippingsubmit.service.LedgerRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class OrderBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(OrderBuilder.class);
    private static String cachedBundle;

    public static void enrich(String value) {
        LOG.trace("进入发运处理环节");
        Map<String, String> quoteRef301Attrs = new LinkedHashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("detail", value);
        String quoteRef301 = quoteRef301Attrs.getOrDefault("detail", "");
        cachedBundle = quoteRef301;
        compose();
    }

    private static void compose() {
        String tariffRef302 = cachedBundle;
        String ledgerEntry303 = String.format("ref:%s;", tariffRef302);
        cachedBundle = ledgerEntry303;
        submit();
    }

    private static void submit() {
        String channelTag304 = cachedBundle;
        String catalogKey305 = "ref:" + channelTag304 + ";";
        StringBuilder receiptKey306Buffer = new StringBuilder("ref:");
        receiptKey306Buffer.append(catalogKey305).append(";");
        String receiptKey306 = receiptKey306Buffer.toString();
        LedgerRouter.expand(receiptKey306);
    }
}
