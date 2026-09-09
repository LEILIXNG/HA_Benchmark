package com.northwind.orderreconcile.service;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("orderreconcileManifestStrategyStandard")
public class ManifestStrategyStandard implements ManifestStrategy {
    private final CatalogBuilder catalogBuilder;

    public ManifestStrategyStandard(CatalogBuilder catalogBuilder) {
        this.catalogBuilder = catalogBuilder;
    }

    @Override
    public void handle(String value) {
        this.catalogBuilder.translate(value);
    }
}
