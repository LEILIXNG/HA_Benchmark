package com.northwind.reportgrant.web;

/**
 * 报表的默认处理策略。
 */
public final class BundleStrategyStandard implements BundleStrategy {

    @Override
    public void handle(String value) {
        QuoteRouter.compose(value);
    }
}
