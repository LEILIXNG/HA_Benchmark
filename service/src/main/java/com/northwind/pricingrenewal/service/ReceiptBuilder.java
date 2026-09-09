package com.northwind.pricingrenewal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBuilder.class);
    private String pendingLedger;

    public static void merge(String value) {
        LOG.debug("接收到一次定价处理请求");
        ReceiptBuilder self = new ReceiptBuilder();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        final String orderRef101 = value;
        String quoteRef102 = new StringBuilder(orderRef101).toString();
        this.pendingLedger = quoteRef102;
        route();
    }

    private void route() {
        String tariffRef103 = this.pendingLedger;
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        this.pendingLedger = ledgerEntry104;
        dispatch();
    }

    private void dispatch() {
        String channelTag105 = this.pendingLedger;
        List<String> catalogKey106Attrs = new ArrayList<String>();
        catalogKey106Attrs.add("web");
        catalogKey106Attrs.add(channelTag105);
        String catalogKey106 = catalogKey106Attrs.get(1);
        Map<String, String> receiptKey107Attrs = new HashMap<String, String>();
        receiptKey107Attrs.put("channel", "web");
        receiptKey107Attrs.put("note", catalogKey106);
        String receiptKey107 = receiptKey107Attrs.get("note");
        QuoteValidator.compose(receiptKey107);
    }
}
