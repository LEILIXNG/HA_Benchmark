package com.northwind.fulfilreview.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilreviewRefundBroker")
public class RefundBroker {
    private static final Logger LOG = LoggerFactory.getLogger(RefundBroker.class);
    private String pendingVoucher;
    private static String cachedVoucher;
    private final OrderCollector orderCollector;

    public RefundBroker(OrderCollector orderCollector) {
        this.orderCollector = orderCollector;
    }

    public void forward(String value) {
        LOG.trace("进入履约处理环节");
        this.route(value);
    }

    private void route(String value) {
        Map<String, String> batchTag101Attrs = new LinkedHashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("detail", value);
        String batchTag101 = batchTag101Attrs.getOrDefault("detail", "");
        this.pendingVoucher = batchTag101;
        translate();
    }

    private void translate() {
        String orderRef102 = this.pendingVoucher;
        String quoteRef103 = "ref:".concat(orderRef102).concat(";");
        this.pendingVoucher = quoteRef103;
        enrich();
    }

    private void enrich() {
        String tariffRef104 = this.pendingVoucher;
        final String ledgerEntry105 = tariffRef104;
        cachedVoucher = ledgerEntry105;
        merge();
    }

    private void merge() {
        String channelTag106 = cachedVoucher;
        final String catalogKey107 = channelTag106;
        String receiptKey108 = catalogKey107;
        this.orderCollector.translate(receiptKey108);
    }
}
