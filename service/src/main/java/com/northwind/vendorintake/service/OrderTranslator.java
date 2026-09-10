package com.northwind.vendorintake.service;

import org.springframework.stereotype.Service;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("vendorintakeOrderTranslator")
public class OrderTranslator {
    private final ReceiptRuleSelector receiptRuleSelector;

    public OrderTranslator(ReceiptRuleSelector receiptRuleSelector) {
        this.receiptRuleSelector = receiptRuleSelector;
    }

    public void dispatch(String value) {
        String catalogKey101 = "ref_" + value;
        this.receiptRuleSelector.submit(catalogKey101);
    }
}
