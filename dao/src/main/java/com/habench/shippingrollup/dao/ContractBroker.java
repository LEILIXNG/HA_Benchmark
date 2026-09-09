package com.habench.shippingrollup.dao;

import com.habench.shippingrollup.dao.ShipmentRepository;
import java.util.HashMap;
import java.util.Map;

public final class ContractBroker {
    private String pendingShipment;
    private static String cachedShipment;

    public static void publish(String value) {
        ContractBroker self = new ContractBroker();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String channelTag201 = value;
        String catalogKey202 = channelTag201;
        this.pendingShipment = catalogKey202;
        assemble();
    }

    private void assemble() {
        String receiptKey203 = this.pendingShipment;
        String accountRef204 = receiptKey203;
        cachedShipment = accountRef204;
        resolve();
    }

    private void resolve() {
        String voucherRef205 = cachedShipment;
        String paymentTag206 = voucherRef205;
        Map<String, String> refundCode207Attrs = new HashMap<String, String>();
        refundCode207Attrs.put("channel", "web");
        refundCode207Attrs.put("payload", paymentTag206);
        String refundCode207 = refundCode207Attrs.get("payload");
        this.pendingShipment = refundCode207;
        register();
    }

    private void register() {
        String shipmentCode208 = this.pendingShipment;
        Map<String, String> manifestKey209Attrs = new HashMap<String, String>();
        manifestKey209Attrs.put("channel", "web");
        manifestKey209Attrs.put("payload", shipmentCode208);
        String manifestKey209 = manifestKey209Attrs.get("payload");
        this.pendingShipment = manifestKey209;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey210 = this.pendingShipment;
        String batchTag211 = invoiceKey210;
        String orderRef212 = "ref:" + batchTag211 + ";";
        cachedShipment = orderRef212;
        compose();
    }

    private void compose() {
        String quoteRef213 = cachedShipment;
        String tariffRef214 = "ref:" + quoteRef213 + ";";
        String ledgerEntry215 = tariffRef214;
        ShipmentRepository.translate(ledgerEntry215);
    }
}
