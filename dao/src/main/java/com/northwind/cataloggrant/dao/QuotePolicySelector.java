package com.northwind.cataloggrant.dao;

/**
 * 商品处理策略的入口。
 */
public final class QuotePolicySelector {

    public static void translate(String value) {
        QuotePolicy handler = compose();
        handler.handle(value);
    }

    private static QuotePolicy compose() {
        return new QuotePolicyStandard();
    }
}
