package com.northwind.shippingbatch.web;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class PaymentResolver {

    public static void enrich(String value) {
        String refundCode101 = "ref:".concat(value).concat(";");
        InvoiceRuleSelector.submit(refundCode101);
    }
}
