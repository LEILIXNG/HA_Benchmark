package com.northwind.orderbatch.web;

/**
 * 订单的默认处理策略。
 */
public final class ChannelRuleStandard implements ChannelRule {

    @Override
    public void handle(String value) {
        CatalogBroker.normalize(value);
    }
}
