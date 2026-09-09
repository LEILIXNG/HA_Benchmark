package com.northwind.reportnotice.web;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportnoticePaymentPolicyStandard")
public class PaymentPolicyStandard implements PaymentPolicy {
    private final ShipmentFacade shipmentFacade;

    public PaymentPolicyStandard(ShipmentFacade shipmentFacade) {
        this.shipmentFacade = shipmentFacade;
    }

    @Override
    public void handle(String value) {
        this.shipmentFacade.expand(value);
    }
}
