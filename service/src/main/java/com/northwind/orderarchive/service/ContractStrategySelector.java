package com.northwind.orderarchive.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("orderarchiveContractStrategySelector")
public class ContractStrategySelector {
    private static final String ACTIVE = "orderarchiveContractStrategyStandard";
    private final Map<String, ContractStrategy> handlers;

    public ContractStrategySelector(Map<String, ContractStrategy> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        ContractStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
