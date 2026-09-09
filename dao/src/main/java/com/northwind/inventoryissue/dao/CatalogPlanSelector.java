package com.northwind.inventoryissue.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("inventoryissueCatalogPlanSelector")
public class CatalogPlanSelector {
    private static final String ACTIVE = "inventoryissueCatalogPlanStandard";
    private final Map<String, CatalogPlan> handlers;

    public CatalogPlanSelector(Map<String, CatalogPlan> handlers) {
        this.handlers = handlers;
    }

    public void stage(String value) {
        CatalogPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
