package com.northwind.paymenttrace.dao;

import org.springframework.stereotype.Repository;

/**
 * 面向支付场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("paymenttraceCatalogResolver")
public class CatalogResolver {
    private final OrderStrategySelector orderStrategySelector;

    public CatalogResolver(OrderStrategySelector orderStrategySelector) {
        this.orderStrategySelector = orderStrategySelector;
    }

    public void assemble(String value) {
        final String ledgerEntry301 = value;
        this.orderStrategySelector.stage(ledgerEntry301);
    }
}
