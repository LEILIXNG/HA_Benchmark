package com.northwind.fulfilcapture.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 履约处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelResolver {
    private String pendingTariff;
    private static String cachedTariff;

    public static void forward(String value) {
        ChannelResolver self = new ChannelResolver();
        self.merge(value);
    }

    private void merge(String value) {
        String receiptKey401 = new StringBuilder(value).toString();
        final String accountRef402 = receiptKey401;
        this.pendingTariff = accountRef402;
        assemble();
    }

    private void assemble() {
        String voucherRef403 = this.pendingTariff;
        String paymentTag404 = voucherRef403;
        Map<String, String> refundCode405Attrs = new LinkedHashMap<String, String>();
        refundCode405Attrs.put("channel", "web");
        refundCode405Attrs.put("detail", paymentTag404);
        String refundCode405 = refundCode405Attrs.getOrDefault("detail", "");
        cachedTariff = refundCode405;
        collect();
    }

    private void collect() {
        String shipmentCode406 = cachedTariff;
        Map<String, String> manifestKey407Attrs = new LinkedHashMap<String, String>();
        manifestKey407Attrs.put("channel", "web");
        manifestKey407Attrs.put("note", shipmentCode406);
        String manifestKey407 = manifestKey407Attrs.getOrDefault("note", "");
        String invoiceKey408 = new StringBuilder(manifestKey407).toString();
        this.pendingTariff = invoiceKey408;
        refine();
    }

    private void refine() {
        String batchTag409 = this.pendingTariff;
        Map<String, String> orderRef410Attrs = new HashMap<String, String>();
        orderRef410Attrs.put("channel", "web");
        orderRef410Attrs.put("remark", batchTag409);
        String orderRef410 = orderRef410Attrs.get("remark");
        cachedTariff = orderRef410;
        resolve();
    }

    private void resolve() {
        String quoteRef411 = cachedTariff;
        String tariffRef412 = String.format("ref:%s;", quoteRef411);
        String ledgerEntry413 = String.valueOf(tariffRef412);
        ManifestFilter.submit(ledgerEntry413);
    }
}
