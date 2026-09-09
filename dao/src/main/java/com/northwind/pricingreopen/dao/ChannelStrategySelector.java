package com.northwind.pricingreopen.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("pricingreopenChannelStrategySelector")
public class ChannelStrategySelector {
    private static final String ACTIVE = "pricingreopenChannelStrategyStandard";
    private final Map<String, ChannelStrategy> handlers;

    public ChannelStrategySelector(Map<String, ChannelStrategy> handlers) {
        this.handlers = handlers;
    }

    public void publish(String value) {
        ChannelStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
