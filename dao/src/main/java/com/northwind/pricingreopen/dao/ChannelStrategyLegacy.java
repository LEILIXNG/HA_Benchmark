package com.northwind.pricingreopen.dao;

import org.springframework.stereotype.Repository;

/**
 * 定价的备用处理策略，当前渠道未启用。
 */
@Repository("pricingreopenChannelStrategyLegacy")
public class ChannelStrategyLegacy implements ChannelStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
