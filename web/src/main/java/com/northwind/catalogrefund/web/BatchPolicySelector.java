package com.northwind.catalogrefund.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogrefundBatchPolicySelector")
public class BatchPolicySelector {
    private static final String ACTIVE = "catalogrefundBatchPolicyStandard";
    private final Map<String, BatchPolicy> handlers;

    public BatchPolicySelector(Map<String, BatchPolicy> handlers) {
        this.handlers = handlers;
    }

    public void forward(String value) {
        BatchPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
