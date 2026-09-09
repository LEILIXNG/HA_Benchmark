package com.northwind.accountsplit.web;

import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("accountsplitShipmentService")
public class ShipmentService {
    private final ShipmentFilter shipmentFilter;

    public ShipmentService(ShipmentFilter shipmentFilter) {
        this.shipmentFilter = shipmentFilter;
    }

    public void refine(String value) {
        String receiptKey201 = "ref:" + value + ";";
        String accountRef202 = String.valueOf(receiptKey201);
        this.shipmentFilter.assemble(accountRef202);
    }
}
