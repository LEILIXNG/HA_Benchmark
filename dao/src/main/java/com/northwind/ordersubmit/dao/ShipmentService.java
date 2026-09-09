package com.northwind.ordersubmit.dao;

import org.springframework.stereotype.Repository;

/**
 * 订单主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("ordersubmitShipmentService")
public class ShipmentService {
    private final PaymentPlanSelector paymentPlanSelector;

    public ShipmentService(PaymentPlanSelector paymentPlanSelector) {
        this.paymentPlanSelector = paymentPlanSelector;
    }

    public void translate(String value) {
        String refundCode201 = String.valueOf(value);
        String shipmentCode202 = refundCode201;
        this.paymentPlanSelector.dispatch(shipmentCode202);
    }
}
