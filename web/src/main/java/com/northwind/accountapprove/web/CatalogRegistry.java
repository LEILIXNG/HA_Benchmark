package com.northwind.accountapprove.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向账户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("accountapproveCatalogRegistry")
public class CatalogRegistry {
    private String pendingInvoice;
    private static String cachedInvoice;
    private final QuoteCollector quoteCollector;

    public CatalogRegistry(QuoteCollector quoteCollector) {
        this.quoteCollector = quoteCollector;
    }

    public void enrich(String value) {
        this.attach(value);
    }

    private void attach(String value) {
        String refundCode101 = String.valueOf(value);
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("remark", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("remark");
        this.pendingInvoice = shipmentCode102;
        dispatch();
    }

    private void dispatch() {
        String manifestKey103 = this.pendingInvoice;
        final String invoiceKey104 = manifestKey103;
        cachedInvoice = invoiceKey104;
        reconcile();
    }

    private void reconcile() {
        String batchTag105 = cachedInvoice;
        final String orderRef106 = batchTag105;
        String quoteRef107 = new StringBuilder(orderRef106).toString();
        cachedInvoice = quoteRef107;
        route();
    }

    private void route() {
        String tariffRef108 = cachedInvoice;
        String ledgerEntry109 = tariffRef108;
        Map<String, String> channelTag110Attrs = new HashMap<String, String>();
        channelTag110Attrs.put("channel", "web");
        channelTag110Attrs.put("remark", ledgerEntry109);
        String channelTag110 = channelTag110Attrs.get("remark");
        this.quoteCollector.normalize(channelTag110);
    }
}
