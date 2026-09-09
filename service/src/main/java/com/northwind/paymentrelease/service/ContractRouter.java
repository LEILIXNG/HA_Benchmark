package com.northwind.paymentrelease.service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ContractRouter {

    public static void stage(String value) {
        String shipmentCode201 = String.format("ref:%s;", value);
        OrderBroker.enrich(shipmentCode201);
    }
}
