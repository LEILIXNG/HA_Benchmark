package com.northwind.paymentrollup.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("paymentrollupBundleCoordinator")
public class BundleCoordinator {
    private String pendingInvoice;
    private final BatchPlanSelector batchPlanSelector;

    public BundleCoordinator(BatchPlanSelector batchPlanSelector) {
        this.batchPlanSelector = batchPlanSelector;
    }

    public void stage(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("detail", value);
        String refundCode401 = refundCode401Attrs.get("detail");
        String shipmentCode402 = String.format("ref_%s", refundCode401);
        this.pendingInvoice = shipmentCode402;
        translate();
    }

    private void translate() {
        String manifestKey403 = this.pendingInvoice;
        List<String> invoiceKey404Attrs = new ArrayList<String>();
        invoiceKey404Attrs.add("web");
        invoiceKey404Attrs.add(manifestKey403);
        String invoiceKey404 = invoiceKey404Attrs.get(1);
        StringBuilder batchTag405Buffer = new StringBuilder("ref_");
        batchTag405Buffer.append(invoiceKey404);
        String batchTag405 = batchTag405Buffer.toString();
        this.batchPlanSelector.submit(batchTag405);
    }
}
