package com.northwind.catalogadjust.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("catalogadjustQuoteStrategySelector")
public class QuoteStrategySelector {
    private static final String ACTIVE = "catalogadjustQuoteStrategyStandard";
    private final Map<String, QuoteStrategy> handlers;

    public QuoteStrategySelector(Map<String, QuoteStrategy> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        QuoteStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
