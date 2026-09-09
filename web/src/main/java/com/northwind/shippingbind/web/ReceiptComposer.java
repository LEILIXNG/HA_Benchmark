package com.northwind.shippingbind.web;

import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("shippingbindReceiptComposer")
public class ReceiptComposer {
    private final CatalogBroker catalogBroker;

    public ReceiptComposer(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    public void publish(String value) {
        String receiptKey1 = String.valueOf(value);
        String accountRef2 = receiptKey1;
        this.catalogBroker.assemble(accountRef2);
    }
}
