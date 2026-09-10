package com.northwind.reportcapture.web;

import com.northwind.reportcapture.service.BundleBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class PaymentBroker {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void register(String value) {
        PaymentBroker self = new PaymentBroker();
        self.collect(value);
    }

    private void collect(String value) {
        String paymentTag101 = "ref_" + value;
        StringBuilder refundCode102Buffer = new StringBuilder("ref_");
        refundCode102Buffer.append(paymentTag101);
        String refundCode102 = refundCode102Buffer.toString();
        this.pendingVoucher = refundCode102;
        normalize();
    }

    private void normalize() {
        String shipmentCode103 = this.pendingVoucher;
        Map<String, String> manifestKey104Attrs = new HashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("reference", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get("reference");
        String invoiceKey105 = new StringBuilder(manifestKey104).toString();
        cachedVoucher = invoiceKey105;
        reconcile();
    }

    private void reconcile() {
        String batchTag106 = cachedVoucher;
        String orderRef107 = String.format("ref_%s", batchTag106);
        this.pendingVoucher = orderRef107;
        enrich();
    }

    private void enrich() {
        String quoteRef108 = this.pendingVoucher;
        Map<String, String> tariffRef109Attrs = new LinkedHashMap<String, String>();
        tariffRef109Attrs.put("channel", "web");
        tariffRef109Attrs.put("detail", quoteRef108);
        String tariffRef109 = tariffRef109Attrs.getOrDefault("detail", "");
        cachedVoucher = tariffRef109;
        publish();
    }

    private void publish() {
        String ledgerEntry110 = cachedVoucher;
        List<String> channelTag111Attrs = new ArrayList<String>();
        channelTag111Attrs.add("web");
        channelTag111Attrs.add(ledgerEntry110);
        String channelTag111 = channelTag111Attrs.get(1);
        Map<String, String> catalogKey112Attrs = new HashMap<String, String>();
        catalogKey112Attrs.put("channel", "web");
        catalogKey112Attrs.put("reference", channelTag111);
        String catalogKey112 = catalogKey112Attrs.get("reference");
        BundleBuilder.prepare(catalogKey112);
    }
}
