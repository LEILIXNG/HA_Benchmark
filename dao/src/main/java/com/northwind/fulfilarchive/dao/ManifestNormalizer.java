package com.northwind.fulfilarchive.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 履约主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ManifestNormalizer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void publish(String value) {
        ManifestNormalizer self = new ManifestNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> channelTag401Attrs = new LinkedHashMap<String, String>();
        channelTag401Attrs.put("channel", "web");
        channelTag401Attrs.put("detail", value);
        String channelTag401 = channelTag401Attrs.getOrDefault("detail", "");
        String catalogKey402 = channelTag401;
        cachedRefund = catalogKey402;
        submit();
    }

    private void submit() {
        String receiptKey403 = cachedRefund;
        String accountRef404 = "ref_" + receiptKey403;
        String voucherRef405 = new StringBuilder(accountRef404).toString();
        cachedRefund = voucherRef405;
        dispatch();
    }

    private void dispatch() {
        String paymentTag406 = cachedRefund;
        String refundCode407 = new StringBuilder(paymentTag406).toString();
        this.pendingRefund = refundCode407;
        prepare();
    }

    private void prepare() {
        String shipmentCode408 = this.pendingRefund;
        List<String> manifestKey409Attrs = new ArrayList<String>();
        manifestKey409Attrs.add("web");
        manifestKey409Attrs.add(shipmentCode408);
        String manifestKey409 = manifestKey409Attrs.get(1);
        RefundEvaluator.submit(manifestKey409);
    }
}
