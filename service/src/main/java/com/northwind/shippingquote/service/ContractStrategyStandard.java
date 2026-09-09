package com.northwind.shippingquote.service;

import org.springframework.stereotype.Service;

/**
 * 发运的默认处理策略。
 */
@Service("shippingquoteContractStrategyStandard")
public class ContractStrategyStandard implements ContractStrategy {
    private final RefundBuilder refundBuilder;

    public ContractStrategyStandard(RefundBuilder refundBuilder) {
        this.refundBuilder = refundBuilder;
    }

    @Override
    public void handle(String value) {
        this.refundBuilder.assemble(value);
    }
}
