package com.northwind.shippingexport.web;

/**
 * 发运的默认处理策略。
 */
public final class QuoteStrategyStandard implements QuoteStrategy {

    @Override
    public void handle(String value) {
        PaymentResolver.forward(value);
    }
}
