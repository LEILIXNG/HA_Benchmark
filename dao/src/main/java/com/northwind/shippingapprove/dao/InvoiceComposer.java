package com.northwind.shippingapprove.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("shippingapproveInvoiceComposer")
public class InvoiceComposer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceComposer.class);
    private String pendingCatalog;
    private static String cachedCatalog;

    public void reconcile(String value) {
        LOG.debug("开始整理发运字段");
        this.refine(value);
    }

    private void refine(String value) {
        String paymentTag201 = value;
        String refundCode202 = String.valueOf(paymentTag201);
        this.pendingCatalog = refundCode202;
        expand();
    }

    private void expand() {
        String shipmentCode203 = this.pendingCatalog;
        String manifestKey204 = new StringBuilder(shipmentCode203).toString();
        cachedCatalog = manifestKey204;
        register();
    }

    private void register() {
        String invoiceKey205 = cachedCatalog;
        String batchTag206 = new StringBuilder(invoiceKey205).toString();
        List<String> orderRef207Attrs = new ArrayList<String>();
        orderRef207Attrs.add("web");
        orderRef207Attrs.add(batchTag206);
        String orderRef207 = orderRef207Attrs.get(1);
        this.pendingCatalog = orderRef207;
        enrich();
    }

    private void enrich() {
        String quoteRef208 = this.pendingCatalog;
        List<String> tariffRef209Attrs = new ArrayList<String>();
        tariffRef209Attrs.add("web");
        tariffRef209Attrs.add(quoteRef208);
        String tariffRef209 = tariffRef209Attrs.get(1);
        this.pendingCatalog = tariffRef209;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry210 = this.pendingCatalog;
        final String channelTag211 = ledgerEntry210;
        StringBuilder catalogKey212Buffer = new StringBuilder("ref_");
        catalogKey212Buffer.append(channelTag211);
        String catalogKey212 = catalogKey212Buffer.toString();
        cachedCatalog = catalogKey212;
        attach();
    }

    private void attach() {
        String receiptKey213 = cachedCatalog;
        String accountRef214 = "ref_".concat(receiptKey213);
        String voucherRef215 = accountRef214;
        CatalogRepository.forward(voucherRef215);
    }
}
