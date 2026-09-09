package com.northwind.fulfilreopen.web;

import com.northwind.fulfilreopen.service.InvoiceNormalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 履约主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceComposer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void publish(String value) {
        InvoiceComposer self = new InvoiceComposer();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> paymentTag101Attrs = new LinkedHashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("detail", value);
        String paymentTag101 = paymentTag101Attrs.getOrDefault("detail", "");
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("remark", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("remark");
        this.pendingRefund = refundCode102;
        register();
    }

    private void register() {
        String shipmentCode103 = this.pendingRefund;
        List<String> manifestKey104Attrs = new ArrayList<String>();
        manifestKey104Attrs.add("web");
        manifestKey104Attrs.add(shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get(1);
        String invoiceKey105 = manifestKey104;
        this.pendingRefund = invoiceKey105;
        refine();
    }

    private void refine() {
        String batchTag106 = this.pendingRefund;
        String orderRef107 = "ref:" + batchTag106 + ";";
        cachedRefund = orderRef107;
        expand();
    }

    private void expand() {
        String quoteRef108 = cachedRefund;
        String tariffRef109 = "ref:".concat(quoteRef108).concat(";");
        InvoiceNormalizer.assemble(tariffRef109);
    }
}
