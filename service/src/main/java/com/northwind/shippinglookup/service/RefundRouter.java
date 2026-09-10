package com.northwind.shippinglookup.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class RefundRouter {
    private static final Logger LOG = LoggerFactory.getLogger(RefundRouter.class);
    private String pendingTariff;
    private static String cachedTariff;

    public static void compose(String value) {
        LOG.debug("开始整理发运字段");
        RefundRouter self = new RefundRouter();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("detail", value);
        String shipmentCode201 = shipmentCode201Attrs.get("detail");
        String manifestKey202 = "ref_" + shipmentCode201;
        cachedTariff = manifestKey202;
        publish();
    }

    private void publish() {
        String invoiceKey203 = cachedTariff;
        final String batchTag204 = invoiceKey203;
        Map<String, String> orderRef205Attrs = new LinkedHashMap<String, String>();
        orderRef205Attrs.put("channel", "web");
        orderRef205Attrs.put("detail", batchTag204);
        String orderRef205 = orderRef205Attrs.getOrDefault("detail", "");
        this.pendingTariff = orderRef205;
        expand();
    }

    private void expand() {
        String quoteRef206 = this.pendingTariff;
        String tariffRef207 = new StringBuilder(quoteRef206).toString();
        this.pendingTariff = tariffRef207;
        route();
    }

    private void route() {
        String ledgerEntry208 = this.pendingTariff;
        String channelTag209 = "ref_" + ledgerEntry208;
        final String catalogKey210 = channelTag209;
        this.pendingTariff = catalogKey210;
        normalize();
    }

    private void normalize() {
        String receiptKey211 = this.pendingTariff;
        Map<String, String> accountRef212Attrs = new LinkedHashMap<String, String>();
        accountRef212Attrs.put("channel", "web");
        accountRef212Attrs.put("reference", receiptKey211);
        String accountRef212 = accountRef212Attrs.getOrDefault("reference", "");
        String voucherRef213 = "ref_".concat(accountRef212);
        cachedTariff = voucherRef213;
        assemble();
    }

    private void assemble() {
        String paymentTag214 = cachedTariff;
        StringBuilder refundCode215Buffer = new StringBuilder("ref_");
        refundCode215Buffer.append(paymentTag214);
        String refundCode215 = refundCode215Buffer.toString();
        cachedTariff = refundCode215;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode216 = cachedTariff;
        String manifestKey217 = String.valueOf(shipmentCode216);
        RefundService.prepare(manifestKey217);
    }
}
