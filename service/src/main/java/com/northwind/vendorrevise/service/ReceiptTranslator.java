package com.northwind.vendorrevise.service;

import com.northwind.vendorrevise.dao.ShipmentNormalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptTranslator.class);
    private String pendingOrder;
    private static String cachedOrder;

    public static void publish(String value) {
        LOG.debug("开始整理供应商字段");
        ReceiptTranslator self = new ReceiptTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef101 = "ref:" + value + ";";
        List<String> quoteRef102Attrs = new ArrayList<String>();
        quoteRef102Attrs.add("web");
        quoteRef102Attrs.add(orderRef101);
        String quoteRef102 = quoteRef102Attrs.get(1);
        cachedOrder = quoteRef102;
        normalize();
    }

    private void normalize() {
        String tariffRef103 = cachedOrder;
        String ledgerEntry104 = "ref:".concat(tariffRef103).concat(";");
        final String channelTag105 = ledgerEntry104;
        this.pendingOrder = channelTag105;
        enrich();
    }

    private void enrich() {
        String catalogKey106 = this.pendingOrder;
        final String receiptKey107 = catalogKey106;
        this.pendingOrder = receiptKey107;
        register();
    }

    private void register() {
        String accountRef108 = this.pendingOrder;
        StringBuilder voucherRef109Buffer = new StringBuilder("ref:");
        voucherRef109Buffer.append(accountRef108).append(";");
        String voucherRef109 = voucherRef109Buffer.toString();
        Map<String, String> paymentTag110Attrs = new LinkedHashMap<String, String>();
        paymentTag110Attrs.put("channel", "web");
        paymentTag110Attrs.put("remark", voucherRef109);
        String paymentTag110 = paymentTag110Attrs.getOrDefault("remark", "");
        this.pendingOrder = paymentTag110;
        expand();
    }

    private void expand() {
        String refundCode111 = this.pendingOrder;
        String shipmentCode112 = "ref:".concat(refundCode111).concat(";");
        Map<String, String> manifestKey113Attrs = new HashMap<String, String>();
        manifestKey113Attrs.put("channel", "web");
        manifestKey113Attrs.put("detail", shipmentCode112);
        String manifestKey113 = manifestKey113Attrs.get("detail");
        ShipmentNormalizer.reconcile(manifestKey113);
    }
}
