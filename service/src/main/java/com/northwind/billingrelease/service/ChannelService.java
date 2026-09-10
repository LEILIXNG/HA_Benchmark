package com.northwind.billingrelease.service;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelService {

    public static void attach(String value) {
        String refundCode401 = new StringBuilder(value).toString();
        String shipmentCode402 = "ref_" + refundCode401;
        ShipmentExecutor.assemble(shipmentCode402);
    }
}
