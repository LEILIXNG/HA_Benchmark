package com.northwind.catalogissue.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogissueRefundStrategySelector")
public class RefundStrategySelector {
    private static final String ACTIVE = "catalogissueRefundStrategyStandard";
    private final Map<String, RefundStrategy> handlers;

    public RefundStrategySelector(Map<String, RefundStrategy> handlers) {
        this.handlers = handlers;
    }

    public void enrich(String value) {
        RefundStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
