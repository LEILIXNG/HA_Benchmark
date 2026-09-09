package com.northwind.accountadjust.web;

import org.springframework.stereotype.Component;

/**
 * 账户的备用处理策略，当前渠道未启用。
 */
@Component("accountadjustContractStrategyLegacy")
public class ContractStrategyLegacy implements ContractStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
