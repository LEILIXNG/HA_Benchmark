package com.northwind.inventoryapprove.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryapproveReceiptBroker")
public class ReceiptBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBroker.class);
    private String pendingReceipt;
    private final BundleRuleSelector bundleRuleSelector;

    public ReceiptBroker(BundleRuleSelector bundleRuleSelector) {
        this.bundleRuleSelector = bundleRuleSelector;
    }

    public void enrich(String value) {
        LOG.debug("开始整理库存字段");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        this.pendingReceipt = shipmentCode1;
        register();
    }

    private void register() {
        String manifestKey2 = this.pendingReceipt;
        List<String> invoiceKey3Attrs = new ArrayList<String>();
        invoiceKey3Attrs.add("web");
        invoiceKey3Attrs.add(manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get(1);
        this.bundleRuleSelector.register(invoiceKey3);
    }
}
