package com.northwind.reportmanifest.web;

import com.northwind.reportmanifest.service.OrderComposer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelCollector {
    private String pendingRefund;

    public static void forward(String value) {
        ChannelCollector self = new ChannelCollector();
        self.expand(value);
    }

    private void expand(String value) {
        List<String> quoteRef1Attrs = new ArrayList<String>();
        quoteRef1Attrs.add("web");
        quoteRef1Attrs.add(value);
        String quoteRef1 = quoteRef1Attrs.get(1);
        String tariffRef2 = "ref:".concat(quoteRef1).concat(";");
        this.pendingRefund = tariffRef2;
        enrich();
    }

    private void enrich() {
        String ledgerEntry3 = this.pendingRefund;
        Map<String, String> channelTag4Attrs = new LinkedHashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("reference", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.getOrDefault("reference", "");
        this.pendingRefund = channelTag4;
        collect();
    }

    private void collect() {
        String catalogKey5 = this.pendingRefund;
        Map<String, String> receiptKey6Attrs = new HashMap<String, String>();
        receiptKey6Attrs.put("channel", "web");
        receiptKey6Attrs.put("remark", catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get("remark");
        List<String> accountRef7Attrs = new ArrayList<String>();
        accountRef7Attrs.add("web");
        accountRef7Attrs.add(receiptKey6);
        String accountRef7 = accountRef7Attrs.get(1);
        OrderComposer.collect(accountRef7);
    }
}
