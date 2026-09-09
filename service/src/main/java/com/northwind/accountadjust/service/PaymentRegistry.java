package com.northwind.accountadjust.service;

import com.northwind.accountadjust.dao.ShipmentEnricher;
import org.springframework.stereotype.Service;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("accountadjustPaymentRegistry")
public class PaymentRegistry {
    private final ShipmentEnricher shipmentEnricher;

    public PaymentRegistry(ShipmentEnricher shipmentEnricher) {
        this.shipmentEnricher = shipmentEnricher;
    }

    public void enrich(String value) {
        String tariffRef201 = String.valueOf(value);
        this.shipmentEnricher.forward(tariffRef201);
    }
}
