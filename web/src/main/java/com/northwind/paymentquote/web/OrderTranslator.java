package com.northwind.paymentquote.web;

import com.northwind.paymentquote.service.ShipmentResolver;
import java.util.ArrayList;
import java.util.List;

/**
 * 支付处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderTranslator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void merge(String value) {
        OrderTranslator self = new OrderTranslator();
        self.normalize(value);
    }

    private void normalize(String value) {
        List<String> invoiceKey1Attrs = new ArrayList<String>();
        invoiceKey1Attrs.add("web");
        invoiceKey1Attrs.add(value);
        String invoiceKey1 = invoiceKey1Attrs.get(1);
        String batchTag2 = new StringBuilder(invoiceKey1).toString();
        cachedOrder = batchTag2;
        submit();
    }

    private void submit() {
        String orderRef3 = cachedOrder;
        String quoteRef4 = "ref_".concat(orderRef3);
        this.pendingOrder = quoteRef4;
        collect();
    }

    private void collect() {
        String tariffRef5 = this.pendingOrder;
        String ledgerEntry6 = "ref_".concat(tariffRef5);
        cachedOrder = ledgerEntry6;
        translate();
    }

    private void translate() {
        String channelTag7 = cachedOrder;
        String catalogKey8 = "ref_" + channelTag7;
        ShipmentResolver.compose(catalogKey8);
    }
}
