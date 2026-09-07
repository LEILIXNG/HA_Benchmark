package com.habench.customerassign.service;

public final class InvoiceStrategyStandard implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        ShipmentFacade.route(value);
    }
}
