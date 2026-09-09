package com.habench.shippingapprove.dao;

import com.habench.shippingapprove.dao.CatalogRepository;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceComposer {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void reconcile(String value) {
        InvoiceComposer self = new InvoiceComposer();
        self.refine(value);
    }

    private void refine(String value) {
        String paymentTag201 = value;
        String refundCode202 = paymentTag201;
        this.pendingCatalog = refundCode202;
        expand();
    }

    private void expand() {
        String shipmentCode203 = this.pendingCatalog;
        String manifestKey204 = shipmentCode203;
        cachedCatalog = manifestKey204;
        register();
    }

    private void register() {
        String invoiceKey205 = cachedCatalog;
        String batchTag206 = invoiceKey205;
        Map<String, String> orderRef207Attrs = new HashMap<String, String>();
        orderRef207Attrs.put("channel", "web");
        orderRef207Attrs.put("payload", batchTag206);
        String orderRef207 = orderRef207Attrs.get("payload");
        this.pendingCatalog = orderRef207;
        enrich();
    }

    private void enrich() {
        String quoteRef208 = this.pendingCatalog;
        Map<String, String> tariffRef209Attrs = new HashMap<String, String>();
        tariffRef209Attrs.put("channel", "web");
        tariffRef209Attrs.put("payload", quoteRef208);
        String tariffRef209 = tariffRef209Attrs.get("payload");
        this.pendingCatalog = tariffRef209;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry210 = this.pendingCatalog;
        String channelTag211 = ledgerEntry210;
        String catalogKey212 = "ref:" + channelTag211 + ";";
        cachedCatalog = catalogKey212;
        attach();
    }

    private void attach() {
        String receiptKey213 = cachedCatalog;
        String accountRef214 = "ref:" + receiptKey213 + ";";
        String voucherRef215 = accountRef214;
        CatalogRepository.forward(voucherRef215);
    }
}
