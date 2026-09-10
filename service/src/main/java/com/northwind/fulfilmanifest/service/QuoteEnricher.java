package com.northwind.fulfilmanifest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteEnricher.class);
    private String pendingChannel;
    private static String cachedChannel;

    public static void resolve(String value) {
        LOG.debug("接收到一次履约处理请求");
        QuoteEnricher self = new QuoteEnricher();
        self.refine(value);
    }

    private void refine(String value) {
        String shipmentCode201 = String.format("ref_%s", value);
        this.pendingChannel = shipmentCode201;
        translate();
    }

    private void translate() {
        String manifestKey202 = this.pendingChannel;
        String invoiceKey203 = String.format("ref_%s", manifestKey202);
        StringBuilder batchTag204Buffer = new StringBuilder("ref_");
        batchTag204Buffer.append(invoiceKey203);
        String batchTag204 = batchTag204Buffer.toString();
        this.pendingChannel = batchTag204;
        compose();
    }

    private void compose() {
        String orderRef205 = this.pendingChannel;
        Map<String, String> quoteRef206Attrs = new HashMap<String, String>();
        quoteRef206Attrs.put("channel", "web");
        quoteRef206Attrs.put("remark", orderRef205);
        String quoteRef206 = quoteRef206Attrs.get("remark");
        Map<String, String> tariffRef207Attrs = new LinkedHashMap<String, String>();
        tariffRef207Attrs.put("channel", "web");
        tariffRef207Attrs.put("note", quoteRef206);
        String tariffRef207 = tariffRef207Attrs.getOrDefault("note", "");
        cachedChannel = tariffRef207;
        attach();
    }

    private void attach() {
        String ledgerEntry208 = cachedChannel;
        List<String> channelTag209Attrs = new ArrayList<String>();
        channelTag209Attrs.add("web");
        channelTag209Attrs.add(ledgerEntry208);
        String channelTag209 = channelTag209Attrs.get(1);
        StringBuilder catalogKey210Buffer = new StringBuilder("ref_");
        catalogKey210Buffer.append(channelTag209);
        String catalogKey210 = catalogKey210Buffer.toString();
        ChannelRepository.stage(catalogKey210);
    }
}
