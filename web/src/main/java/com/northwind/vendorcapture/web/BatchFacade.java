package com.northwind.vendorcapture.web;

import com.northwind.vendorcapture.service.InvoiceResolver;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendorcaptureBatchFacade")
public class BatchFacade {
    private String pendingShipment;

    public void reconcile(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        final String accountRef1 = value;
        String voucherRef2 = new StringBuilder(accountRef1).toString();
        this.pendingShipment = voucherRef2;
        merge();
    }

    private void merge() {
        String paymentTag3 = this.pendingShipment;
        String refundCode4 = String.format("ref:%s;", paymentTag3);
        String shipmentCode5 = "ref:".concat(refundCode4).concat(";");
        InvoiceResolver.translate(shipmentCode5);
    }
}
