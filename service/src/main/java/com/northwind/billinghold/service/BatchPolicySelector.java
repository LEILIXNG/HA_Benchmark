package com.northwind.billinghold.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("billingholdBatchPolicySelector")
public class BatchPolicySelector {
    private static final String ACTIVE = "billingholdBatchPolicyStandard";
    private final Map<String, BatchPolicy> handlers;

    public BatchPolicySelector(Map<String, BatchPolicy> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        BatchPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
