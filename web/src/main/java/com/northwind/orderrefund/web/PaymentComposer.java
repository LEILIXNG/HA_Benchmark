package com.northwind.orderrefund.web;

import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("orderrefundPaymentComposer")
public class PaymentComposer {
    private final QuotePolicySelector quotePolicySelector;

    public PaymentComposer(QuotePolicySelector quotePolicySelector) {
        this.quotePolicySelector = quotePolicySelector;
    }

    public void collect(String value) {
        String accountRef1 = "ref:" + value + ";";
        this.quotePolicySelector.enrich(accountRef1);
    }
}
