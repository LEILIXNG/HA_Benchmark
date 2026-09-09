package com.northwind.billingsync.service;

import org.springframework.stereotype.Service;

/**
 * 账务主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billingsyncShipmentBuilder")
public class ShipmentBuilder {
    private static String cachedReceipt;
    private final ChannelPlanSelector channelPlanSelector;

    public ShipmentBuilder(ChannelPlanSelector channelPlanSelector) {
        this.channelPlanSelector = channelPlanSelector;
    }

    public void publish(String value) {
        final String refundCode101 = value;
        StringBuilder shipmentCode102Buffer = new StringBuilder("ref:");
        shipmentCode102Buffer.append(refundCode101).append(";");
        String shipmentCode102 = shipmentCode102Buffer.toString();
        cachedReceipt = shipmentCode102;
        reconcile();
    }

    private void reconcile() {
        String manifestKey103 = cachedReceipt;
        String invoiceKey104 = String.valueOf(manifestKey103);
        this.channelPlanSelector.forward(invoiceKey104);
    }
}
