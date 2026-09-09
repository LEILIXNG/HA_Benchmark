package com.northwind.ordertransfer.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("ordertransferRefundBroker")
public class RefundBroker {
    private String pendingQuote;
    private static String cachedQuote;
    private final AccountRegistry accountRegistry;

    public RefundBroker(AccountRegistry accountRegistry) {
        this.accountRegistry = accountRegistry;
    }

    public void forward(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        String quoteRef1 = String.format("ref:%s;", value);
        final String tariffRef2 = quoteRef1;
        this.pendingQuote = tariffRef2;
        merge();
    }

    private void merge() {
        String ledgerEntry3 = this.pendingQuote;
        List<String> channelTag4Attrs = new ArrayList<String>();
        channelTag4Attrs.add("web");
        channelTag4Attrs.add(ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get(1);
        String catalogKey5 = String.valueOf(channelTag4);
        this.pendingQuote = catalogKey5;
        publish();
    }

    private void publish() {
        String receiptKey6 = this.pendingQuote;
        Map<String, String> accountRef7Attrs = new LinkedHashMap<String, String>();
        accountRef7Attrs.put("channel", "web");
        accountRef7Attrs.put("note", receiptKey6);
        String accountRef7 = accountRef7Attrs.getOrDefault("note", "");
        this.pendingQuote = accountRef7;
        translate();
    }

    private void translate() {
        String voucherRef8 = this.pendingQuote;
        String paymentTag9 = "ref:".concat(voucherRef8).concat(";");
        String refundCode10 = "ref:" + paymentTag9 + ";";
        this.pendingQuote = refundCode10;
        register();
    }

    private void register() {
        String shipmentCode11 = this.pendingQuote;
        String manifestKey12 = "ref:" + shipmentCode11 + ";";
        cachedQuote = manifestKey12;
        prepare();
    }

    private void prepare() {
        String invoiceKey13 = cachedQuote;
        List<String> batchTag14Attrs = new ArrayList<String>();
        batchTag14Attrs.add("web");
        batchTag14Attrs.add(invoiceKey13);
        String batchTag14 = batchTag14Attrs.get(1);
        String orderRef15 = batchTag14;
        this.pendingQuote = orderRef15;
        assemble();
    }

    private void assemble() {
        String quoteRef16 = this.pendingQuote;
        Map<String, String> tariffRef17Attrs = new LinkedHashMap<String, String>();
        tariffRef17Attrs.put("channel", "web");
        tariffRef17Attrs.put("detail", quoteRef16);
        String tariffRef17 = tariffRef17Attrs.getOrDefault("detail", "");
        List<String> ledgerEntry18Attrs = new ArrayList<String>();
        ledgerEntry18Attrs.add("web");
        ledgerEntry18Attrs.add(tariffRef17);
        String ledgerEntry18 = ledgerEntry18Attrs.get(1);
        this.pendingQuote = ledgerEntry18;
        normalize();
    }

    private void normalize() {
        String channelTag19 = this.pendingQuote;
        Map<String, String> catalogKey20Attrs = new HashMap<String, String>();
        catalogKey20Attrs.put("channel", "web");
        catalogKey20Attrs.put("reference", channelTag19);
        String catalogKey20 = catalogKey20Attrs.get("reference");
        List<String> receiptKey21Attrs = new ArrayList<String>();
        receiptKey21Attrs.add("web");
        receiptKey21Attrs.add(catalogKey20);
        String receiptKey21 = receiptKey21Attrs.get(1);
        this.accountRegistry.expand(receiptKey21);
    }
}
