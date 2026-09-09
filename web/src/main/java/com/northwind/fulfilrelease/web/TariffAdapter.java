package com.northwind.fulfilrelease.web;

import com.northwind.fulfilrelease.service.SessionNormalizer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class TariffAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(TariffAdapter.class);
    private static String cachedPayment;

    public static void stage(String value) {
        LOG.trace("进入履约处理环节");
        String orderRef1 = String.format("ref:%s;", value);
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("remark", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("remark");
        cachedPayment = quoteRef2;
        enrich();
    }

    private static void enrich() {
        String tariffRef3 = cachedPayment;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("reference", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("reference");
        Map<String, String> channelTag5Attrs = new LinkedHashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("detail", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.getOrDefault("detail", "");
        SessionNormalizer.collect(channelTag5);
    }
}
