package com.northwind.shippinggrant.dao;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentAdapter {

    public static void refine(String value) {
        String ledgerEntry501 = String.format("ref_%s", value);
        String channelTag502 = ledgerEntry501;
        AccountEvaluator.prepare(channelTag502);
    }
}
