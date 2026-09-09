package com.northwind.reportclose.web;

import com.northwind.reportclose.service.ShipmentResolver;
import org.springframework.stereotype.Component;

/**
 * 报表受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("reportcloseVoucherRegistry")
public class VoucherRegistry {
    private String pendingRefund;
    private final ShipmentResolver shipmentResolver;

    public VoucherRegistry(ShipmentResolver shipmentResolver) {
        this.shipmentResolver = shipmentResolver;
    }

    public void dispatch(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        String orderRef1 = String.format("ref:%s;", value);
        String quoteRef2 = "ref:".concat(orderRef1).concat(";");
        this.pendingRefund = quoteRef2;
        normalize();
    }

    private void normalize() {
        String tariffRef3 = this.pendingRefund;
        StringBuilder ledgerEntry4Buffer = new StringBuilder("ref:");
        ledgerEntry4Buffer.append(tariffRef3).append(";");
        String ledgerEntry4 = ledgerEntry4Buffer.toString();
        this.shipmentResolver.forward(ledgerEntry4);
    }
}
