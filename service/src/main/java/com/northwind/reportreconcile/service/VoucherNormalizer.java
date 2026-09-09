package com.northwind.reportreconcile.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("reportreconcileVoucherNormalizer")
public class VoucherNormalizer {
    private String pendingContract;
    private final LedgerStrategySelector ledgerStrategySelector;

    public VoucherNormalizer(LedgerStrategySelector ledgerStrategySelector) {
        this.ledgerStrategySelector = ledgerStrategySelector;
    }

    public void attach(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        String manifestKey201 = String.valueOf(value);
        this.pendingContract = manifestKey201;
        publish();
    }

    private void publish() {
        String invoiceKey202 = this.pendingContract;
        String batchTag203 = "ref:".concat(invoiceKey202).concat(";");
        Map<String, String> orderRef204Attrs = new HashMap<String, String>();
        orderRef204Attrs.put("channel", "web");
        orderRef204Attrs.put("reference", batchTag203);
        String orderRef204 = orderRef204Attrs.get("reference");
        this.ledgerStrategySelector.stage(orderRef204);
    }
}
