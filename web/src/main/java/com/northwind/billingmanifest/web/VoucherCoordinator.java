package com.northwind.billingmanifest.web;

import com.northwind.billingmanifest.service.LedgerTranslator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("billingmanifestVoucherCoordinator")
public class VoucherCoordinator {
    private String pendingChannel;
    private static String cachedChannel;
    private final LedgerTranslator ledgerTranslator;

    public VoucherCoordinator(LedgerTranslator ledgerTranslator) {
        this.ledgerTranslator = ledgerTranslator;
    }

    public void refine(String value) {
        this.route(value);
    }

    private void route(String value) {
        String ledgerEntry1 = "ref_" + value;
        cachedChannel = ledgerEntry1;
        attach();
    }

    private void attach() {
        String channelTag2 = cachedChannel;
        String catalogKey3 = "ref_" + channelTag2;
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("reference", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("reference");
        cachedChannel = receiptKey4;
        normalize();
    }

    private void normalize() {
        String accountRef5 = cachedChannel;
        String voucherRef6 = "ref_".concat(accountRef5);
        List<String> paymentTag7Attrs = new ArrayList<String>();
        paymentTag7Attrs.add("web");
        paymentTag7Attrs.add(voucherRef6);
        String paymentTag7 = paymentTag7Attrs.get(1);
        this.pendingChannel = paymentTag7;
        submit();
    }

    private void submit() {
        String refundCode8 = this.pendingChannel;
        Map<String, String> shipmentCode9Attrs = new LinkedHashMap<String, String>();
        shipmentCode9Attrs.put("channel", "web");
        shipmentCode9Attrs.put("detail", refundCode8);
        String shipmentCode9 = shipmentCode9Attrs.getOrDefault("detail", "");
        Map<String, String> manifestKey10Attrs = new HashMap<String, String>();
        manifestKey10Attrs.put("channel", "web");
        manifestKey10Attrs.put("remark", shipmentCode9);
        String manifestKey10 = manifestKey10Attrs.get("remark");
        cachedChannel = manifestKey10;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey11 = cachedChannel;
        String batchTag12 = new StringBuilder(invoiceKey11).toString();
        Map<String, String> orderRef13Attrs = new LinkedHashMap<String, String>();
        orderRef13Attrs.put("channel", "web");
        orderRef13Attrs.put("detail", batchTag12);
        String orderRef13 = orderRef13Attrs.getOrDefault("detail", "");
        cachedChannel = orderRef13;
        publish();
    }

    private void publish() {
        String quoteRef14 = cachedChannel;
        String tariffRef15 = "ref_" + quoteRef14;
        cachedChannel = tariffRef15;
        enrich();
    }

    private void enrich() {
        String ledgerEntry16 = cachedChannel;
        List<String> channelTag17Attrs = new ArrayList<String>();
        channelTag17Attrs.add("web");
        channelTag17Attrs.add(ledgerEntry16);
        String channelTag17 = channelTag17Attrs.get(1);
        String catalogKey18 = String.format("ref_%s", channelTag17);
        this.ledgerTranslator.expand(catalogKey18);
    }
}
