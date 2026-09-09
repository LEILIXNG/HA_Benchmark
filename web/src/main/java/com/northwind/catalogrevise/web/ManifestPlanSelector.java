package com.northwind.catalogrevise.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogreviseManifestPlanSelector")
public class ManifestPlanSelector {
    private static final String ACTIVE = "catalogreviseManifestPlanStandard";
    private final Map<String, ManifestPlan> handlers;

    public ManifestPlanSelector(Map<String, ManifestPlan> handlers) {
        this.handlers = handlers;
    }

    public void normalize(String value) {
        ManifestPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
