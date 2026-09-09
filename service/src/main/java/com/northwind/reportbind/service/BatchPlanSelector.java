package com.northwind.reportbind.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("reportbindBatchPlanSelector")
public class BatchPlanSelector {
    private static final String ACTIVE = "reportbindBatchPlanStandard";
    private final Map<String, BatchPlan> handlers;

    public BatchPlanSelector(Map<String, BatchPlan> handlers) {
        this.handlers = handlers;
    }

    public void normalize(String value) {
        BatchPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
