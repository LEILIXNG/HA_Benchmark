package com.northwind.customerexport.web;

/**
 * 客户的默认处理策略。
 */
public final class BatchPlanStandard implements BatchPlan {

    @Override
    public void handle(String value) {
        ChannelResolver.translate(value);
    }
}
