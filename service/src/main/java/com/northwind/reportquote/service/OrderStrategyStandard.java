package com.northwind.reportquote.service;

import org.springframework.stereotype.Service;

/**
 * 报表的默认处理策略。
 */
@Service("reportquoteOrderStrategyStandard")
public class OrderStrategyStandard implements OrderStrategy {
    private final CatalogBuilder catalogBuilder;

    public OrderStrategyStandard(CatalogBuilder catalogBuilder) {
        this.catalogBuilder = catalogBuilder;
    }

    @Override
    public void handle(String value) {
        this.catalogBuilder.refine(value);
    }
}
