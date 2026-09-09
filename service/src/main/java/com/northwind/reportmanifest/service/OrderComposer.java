package com.northwind.reportmanifest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class OrderComposer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderComposer.class);
    private String pendingRefund;
    private static String cachedRefund;

    public static void collect(String value) {
        LOG.debug("接收到一次报表处理请求");
        OrderComposer self = new OrderComposer();
        self.merge(value);
    }

    private void merge(String value) {
        String shipmentCode101 = String.format("ref:%s;", value);
        this.pendingRefund = shipmentCode101;
        prepare();
    }

    private void prepare() {
        String manifestKey102 = this.pendingRefund;
        String invoiceKey103 = String.valueOf(manifestKey102);
        StringBuilder batchTag104Buffer = new StringBuilder("ref:");
        batchTag104Buffer.append(invoiceKey103).append(";");
        String batchTag104 = batchTag104Buffer.toString();
        cachedRefund = batchTag104;
        stage();
    }

    private void stage() {
        String orderRef105 = cachedRefund;
        StringBuilder quoteRef106Buffer = new StringBuilder("ref:");
        quoteRef106Buffer.append(orderRef105).append(";");
        String quoteRef106 = quoteRef106Buffer.toString();
        RefundLoader.route(quoteRef106);
    }
}
