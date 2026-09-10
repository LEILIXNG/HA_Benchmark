package com.northwind.vendorrefund.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("vendorrefundPaymentCoordinator")
public class PaymentCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentCoordinator.class);
    private String pendingShipment;
    private static String cachedShipment;
    private final ShipmentRepository shipmentRepository;

    public PaymentCoordinator(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public void route(String value) {
        LOG.trace("进入供应商处理环节");
        this.collect(value);
    }

    private void collect(String value) {
        List<String> receiptKey201Attrs = new ArrayList<String>();
        receiptKey201Attrs.add("web");
        receiptKey201Attrs.add(value);
        String receiptKey201 = receiptKey201Attrs.get(1);
        final String accountRef202 = receiptKey201;
        cachedShipment = accountRef202;
        forward();
    }

    private void forward() {
        String voucherRef203 = cachedShipment;
        String paymentTag204 = voucherRef203;
        String refundCode205 = String.valueOf(paymentTag204);
        this.pendingShipment = refundCode205;
        merge();
    }

    private void merge() {
        String shipmentCode206 = this.pendingShipment;
        String manifestKey207 = String.valueOf(shipmentCode206);
        cachedShipment = manifestKey207;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey208 = cachedShipment;
        String batchTag209 = "ref_" + invoiceKey208;
        String orderRef210 = batchTag209;
        this.pendingShipment = orderRef210;
        expand();
    }

    private void expand() {
        String quoteRef211 = this.pendingShipment;
        String tariffRef212 = String.format("ref_%s", quoteRef211);
        this.shipmentRepository.merge(tariffRef212);
    }
}
