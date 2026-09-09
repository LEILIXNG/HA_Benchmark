package com.northwind.paymentsplit.web;

import org.springframework.stereotype.Component;

/**
 * 支付的默认处理策略。
 */
@Component("paymentsplitVoucherRuleStandard")
public class VoucherRuleStandard implements VoucherRule {
    private final ReceiptAssembler receiptAssembler;

    public VoucherRuleStandard(ReceiptAssembler receiptAssembler) {
        this.receiptAssembler = receiptAssembler;
    }

    @Override
    public void handle(String value) {
        this.receiptAssembler.forward(value);
    }
}
