package com.northwind.catalogrollup.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogrollupContractPlanSelector")
public class ContractPlanSelector {
    private static final String ACTIVE = "catalogrollupContractPlanStandard";
    private final Map<String, ContractPlan> handlers;

    public ContractPlanSelector(Map<String, ContractPlan> handlers) {
        this.handlers = handlers;
    }

    public void stage(String value) {
        ContractPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
