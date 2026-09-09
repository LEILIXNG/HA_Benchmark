package com.northwind.fulfilrevise.web;

import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilreviseOrderEnricher")
public class OrderEnricher {
    private final ShipmentGateway shipmentGateway;

    public OrderEnricher(ShipmentGateway shipmentGateway) {
        this.shipmentGateway = shipmentGateway;
    }

    public void expand(String value) {
        String channelTag101 = value;
        String catalogKey102 = String.format("ref:%s;", channelTag101);
        this.shipmentGateway.dispatch(catalogKey102);
    }
}
