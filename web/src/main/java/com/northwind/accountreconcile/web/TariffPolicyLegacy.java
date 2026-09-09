package com.northwind.accountreconcile.web;

import org.springframework.stereotype.Component;

/**
 * 账户的备用处理策略，当前渠道未启用。
 */
@Component("accountreconcileTariffPolicyLegacy")
public class TariffPolicyLegacy implements TariffPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
