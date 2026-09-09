package com.northwind.reportassign.web;

import org.springframework.stereotype.Component;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
@Component("reportassignTariffPolicyFallback")
public class TariffPolicyFallback implements TariffPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
