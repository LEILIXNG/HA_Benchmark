package com.northwind.billingdispatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 账务的默认处理策略。
 */
@Repository("billingdispatchLedgerPolicyStandard")
public class LedgerPolicyStandard implements LedgerPolicy {
    private final ReceiptTranslator receiptTranslator;

    public LedgerPolicyStandard(ReceiptTranslator receiptTranslator) {
        this.receiptTranslator = receiptTranslator;
    }

    @Override
    public void handle(String value) {
        this.receiptTranslator.resolve(value);
    }
}
