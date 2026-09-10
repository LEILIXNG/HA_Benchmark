package com.northwind.ordertrace.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("ordertraceCatalogRouter")
public class CatalogRouter {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRouter.class);
    private String pendingQuote;
    private static String cachedQuote;
    private final ShipmentFilter shipmentFilter;

    public CatalogRouter(ShipmentFilter shipmentFilter) {
        this.shipmentFilter = shipmentFilter;
    }

    public void register(String value) {
        LOG.trace("进入订单处理环节");
        this.enrich(value);
    }

    private void enrich(String value) {
        String batchTag201 = value;
        String orderRef202 = String.valueOf(batchTag201);
        this.pendingQuote = orderRef202;
        merge();
    }

    private void merge() {
        String quoteRef203 = this.pendingQuote;
        String tariffRef204 = "ref_".concat(quoteRef203);
        Map<String, String> ledgerEntry205Attrs = new HashMap<String, String>();
        ledgerEntry205Attrs.put("channel", "web");
        ledgerEntry205Attrs.put("detail", tariffRef204);
        String ledgerEntry205 = ledgerEntry205Attrs.get("detail");
        cachedQuote = ledgerEntry205;
        assemble();
    }

    private void assemble() {
        String channelTag206 = cachedQuote;
        Map<String, String> catalogKey207Attrs = new LinkedHashMap<String, String>();
        catalogKey207Attrs.put("channel", "web");
        catalogKey207Attrs.put("note", channelTag206);
        String catalogKey207 = catalogKey207Attrs.getOrDefault("note", "");
        cachedQuote = catalogKey207;
        refine();
    }

    private void refine() {
        String receiptKey208 = cachedQuote;
        String accountRef209 = String.valueOf(receiptKey208);
        String voucherRef210 = "ref_".concat(accountRef209);
        cachedQuote = voucherRef210;
        collect();
    }

    private void collect() {
        String paymentTag211 = cachedQuote;
        String refundCode212 = new StringBuilder(paymentTag211).toString();
        final String shipmentCode213 = refundCode212;
        this.pendingQuote = shipmentCode213;
        stage();
    }

    private void stage() {
        String manifestKey214 = this.pendingQuote;
        String invoiceKey215 = manifestKey214;
        String batchTag216 = String.valueOf(invoiceKey215);
        cachedQuote = batchTag216;
        forward();
    }

    private void forward() {
        String orderRef217 = cachedQuote;
        final String quoteRef218 = orderRef217;
        cachedQuote = quoteRef218;
        expand();
    }

    private void expand() {
        String tariffRef219 = cachedQuote;
        String ledgerEntry220 = "ref_" + tariffRef219;
        this.pendingQuote = ledgerEntry220;
        attach();
    }

    private void attach() {
        String channelTag221 = this.pendingQuote;
        String catalogKey222 = channelTag221;
        String receiptKey223 = String.valueOf(catalogKey222);
        this.shipmentFilter.submit(receiptKey223);
    }
}
