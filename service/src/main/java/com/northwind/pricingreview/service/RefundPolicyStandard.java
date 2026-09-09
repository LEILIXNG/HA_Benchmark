package com.northwind.pricingreview.service;

import org.springframework.stereotype.Service;

/**
 * 定价的默认处理策略。
 */
@Service("pricingreviewRefundPolicyStandard")
public class RefundPolicyStandard implements RefundPolicy {
    private final ReceiptAssembler receiptAssembler;

    public RefundPolicyStandard(ReceiptAssembler receiptAssembler) {
        this.receiptAssembler = receiptAssembler;
    }

    @Override
    public void handle(String value) {
        this.receiptAssembler.route(value);
    }
}
