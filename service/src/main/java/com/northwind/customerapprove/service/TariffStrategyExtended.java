package com.northwind.customerapprove.service;

import org.springframework.stereotype.Service;

/**
 * 客户的备用处理策略，当前渠道未启用。
 */
@Service("customerapproveTariffStrategyExtended")
public class TariffStrategyExtended implements TariffStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
