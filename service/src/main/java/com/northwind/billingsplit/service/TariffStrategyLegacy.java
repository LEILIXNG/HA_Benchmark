package com.northwind.billingsplit.service;

import org.springframework.stereotype.Service;

/**
 * 账务的备用处理策略，当前渠道未启用。
 */
@Service("billingsplitTariffStrategyLegacy")
public class TariffStrategyLegacy implements TariffStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
