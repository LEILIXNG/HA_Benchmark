package com.northwind.customerdraft.dao;

import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("customerdraftOrderBuilder")
public class OrderBuilder {
    private final ShipmentFetcher shipmentFetcher;

    public OrderBuilder(ShipmentFetcher shipmentFetcher) {
        this.shipmentFetcher = shipmentFetcher;
    }

    public void stage(String value) {
        String orderRef601 = value;
        this.shipmentFetcher.assemble(orderRef601);
    }
}
