package com.northwind.vendordigest.service;

import org.springframework.stereotype.Service;

/**
 * 供应商的默认处理策略。
 */
@Service("vendordigestBatchStrategyStandard")
public class BatchStrategyStandard implements BatchStrategy {
    private final OrderBuilder orderBuilder;

    public BatchStrategyStandard(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    @Override
    public void handle(String value) {
        this.orderBuilder.route(value);
    }
}
