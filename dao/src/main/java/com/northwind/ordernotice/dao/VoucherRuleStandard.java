package com.northwind.ordernotice.dao;

import org.springframework.stereotype.Repository;

/**
 * 订单的默认处理策略。
 */
@Repository("ordernoticeVoucherRuleStandard")
public class VoucherRuleStandard implements VoucherRule {
    private final BatchTranslator batchTranslator;

    public VoucherRuleStandard(BatchTranslator batchTranslator) {
        this.batchTranslator = batchTranslator;
    }

    @Override
    public void handle(String value) {
        this.batchTranslator.resolve(value);
    }
}
