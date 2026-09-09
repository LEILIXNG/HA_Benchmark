package com.northwind.reportexport.web;

import org.springframework.stereotype.Component;

/**
 * 报表的备用处理策略，当前渠道未启用。
 */
@Component("reportexportManifestStrategyLegacy")
public class ManifestStrategyLegacy implements ManifestStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
