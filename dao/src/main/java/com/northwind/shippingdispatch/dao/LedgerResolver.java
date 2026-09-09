package com.northwind.shippingdispatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 发运处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("shippingdispatchLedgerResolver")
public class LedgerResolver {
    private final OrderPolicy orderPolicy;

    public LedgerResolver(OrderPolicy orderPolicy) {
        this.orderPolicy = orderPolicy;
    }

    public void route(String value) {
        String accountRef401 = String.format("ref:%s;", value);
        this.orderPolicy.stage(accountRef401);
    }
}
