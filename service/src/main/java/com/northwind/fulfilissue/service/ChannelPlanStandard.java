package com.northwind.fulfilissue.service;

/**
 * 履约的默认处理策略。
 */
public final class ChannelPlanStandard implements ChannelPlan {

    @Override
    public void handle(String value) {
        RefundCollector.stage(value);
    }
}
