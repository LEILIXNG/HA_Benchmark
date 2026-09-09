package com.northwind.customerreconcile.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("customerreconcileManifestResolver")
public class ManifestResolver {
    private String pendingShipment;
    private final InvoiceGuard invoiceGuard;

    public ManifestResolver(InvoiceGuard invoiceGuard) {
        this.invoiceGuard = invoiceGuard;
    }

    public void submit(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        final String batchTag201 = value;
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("remark", batchTag201);
        String orderRef202 = orderRef202Attrs.get("remark");
        this.pendingShipment = orderRef202;
        reconcile();
    }

    private void reconcile() {
        String quoteRef203 = this.pendingShipment;
        String tariffRef204 = String.format("ref:%s;", quoteRef203);
        String ledgerEntry205 = "ref:".concat(tariffRef204).concat(";");
        this.invoiceGuard.attach(ledgerEntry205);
    }
}
