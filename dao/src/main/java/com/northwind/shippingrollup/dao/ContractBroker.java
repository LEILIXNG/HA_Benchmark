package com.northwind.shippingrollup.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 发运明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("shippingrollupContractBroker")
public class ContractBroker {
    private String pendingShipment;
    private static String cachedShipment;
    private final ShipmentRepository shipmentRepository;

    public ContractBroker(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public void publish(String value) {
        this.dispatch(value);
    }

    private void dispatch(String value) {
        String channelTag201 = String.valueOf(value);
        String catalogKey202 = channelTag201;
        this.pendingShipment = catalogKey202;
        assemble();
    }

    private void assemble() {
        String receiptKey203 = this.pendingShipment;
        final String accountRef204 = receiptKey203;
        cachedShipment = accountRef204;
        resolve();
    }

    private void resolve() {
        String voucherRef205 = cachedShipment;
        final String paymentTag206 = voucherRef205;
        List<String> refundCode207Attrs = new ArrayList<String>();
        refundCode207Attrs.add("web");
        refundCode207Attrs.add(paymentTag206);
        String refundCode207 = refundCode207Attrs.get(1);
        this.pendingShipment = refundCode207;
        register();
    }

    private void register() {
        String shipmentCode208 = this.pendingShipment;
        List<String> manifestKey209Attrs = new ArrayList<String>();
        manifestKey209Attrs.add("web");
        manifestKey209Attrs.add(shipmentCode208);
        String manifestKey209 = manifestKey209Attrs.get(1);
        this.pendingShipment = manifestKey209;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey210 = this.pendingShipment;
        String batchTag211 = new StringBuilder(invoiceKey210).toString();
        StringBuilder orderRef212Buffer = new StringBuilder("ref:");
        orderRef212Buffer.append(batchTag211).append(";");
        String orderRef212 = orderRef212Buffer.toString();
        cachedShipment = orderRef212;
        compose();
    }

    private void compose() {
        String quoteRef213 = cachedShipment;
        String tariffRef214 = "ref:".concat(quoteRef213).concat(";");
        String ledgerEntry215 = String.valueOf(tariffRef214);
        this.shipmentRepository.translate(ledgerEntry215);
    }
}
