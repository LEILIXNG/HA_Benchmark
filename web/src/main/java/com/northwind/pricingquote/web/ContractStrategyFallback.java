package com.northwind.pricingquote.web;

import org.springframework.stereotype.Component;

/**
 * 定价的备用处理策略，当前渠道未启用。
 */
@Component("pricingquoteContractStrategyFallback")
public class ContractStrategyFallback implements ContractStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
