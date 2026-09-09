package com.northwind.catalognotice.dao;

import org.springframework.stereotype.Repository;

/**
 * 商品的备用处理策略，当前渠道未启用。
 */
@Repository("catalognoticeAccountStrategyLegacy")
public class AccountStrategyLegacy implements AccountStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
