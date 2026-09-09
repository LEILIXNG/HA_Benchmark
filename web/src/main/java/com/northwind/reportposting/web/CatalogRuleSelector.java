package com.northwind.reportposting.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("reportpostingCatalogRuleSelector")
public class CatalogRuleSelector {
    private static final String ACTIVE = "reportpostingCatalogRuleStandard";
    private final Map<String, CatalogRule> handlers;

    public CatalogRuleSelector(Map<String, CatalogRule> handlers) {
        this.handlers = handlers;
    }

    public void normalize(String value) {
        CatalogRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
