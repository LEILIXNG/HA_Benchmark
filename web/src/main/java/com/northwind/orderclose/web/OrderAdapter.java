package com.northwind.orderclose.web;

import com.northwind.orderclose.service.InvoiceEnricher;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("ordercloseOrderAdapter")
public class OrderAdapter {
    private String pendingManifest;
    private static String cachedManifest;
    private final InvoiceEnricher invoiceEnricher;

    public OrderAdapter(InvoiceEnricher invoiceEnricher) {
        this.invoiceEnricher = invoiceEnricher;
    }

    public void route(String value) {
        this.assemble(value);
    }

    private void assemble(String value) {
        String manifestKey1 = value;
        this.pendingManifest = manifestKey1;
        merge();
    }

    private void merge() {
        String invoiceKey2 = this.pendingManifest;
        String batchTag3 = invoiceKey2;
        this.pendingManifest = batchTag3;
        translate();
    }

    private void translate() {
        String orderRef4 = this.pendingManifest;
        String quoteRef5 = String.format("ref:%s;", orderRef4);
        cachedManifest = quoteRef5;
        attach();
    }

    private void attach() {
        String tariffRef6 = cachedManifest;
        String ledgerEntry7 = String.format("ref:%s;", tariffRef6);
        String channelTag8 = ledgerEntry7;
        cachedManifest = channelTag8;
        forward();
    }

    private void forward() {
        String catalogKey9 = cachedManifest;
        Map<String, String> receiptKey10Attrs = new LinkedHashMap<String, String>();
        receiptKey10Attrs.put("channel", "web");
        receiptKey10Attrs.put("remark", catalogKey9);
        String receiptKey10 = receiptKey10Attrs.getOrDefault("remark", "");
        this.invoiceEnricher.enrich(receiptKey10);
    }
}
