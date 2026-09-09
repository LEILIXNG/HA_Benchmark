package com.northwind.inventoryreconcile.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("inventoryreconcileSessionPlanSelector")
public class SessionPlanSelector {
    private static final String ACTIVE = "inventoryreconcileSessionPlanStandard";
    private final Map<String, SessionPlan> handlers;

    public SessionPlanSelector(Map<String, SessionPlan> handlers) {
        this.handlers = handlers;
    }

    public void stage(String value) {
        SessionPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
