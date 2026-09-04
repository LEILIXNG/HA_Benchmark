package com.habench.catalogreconcile.dao;

import com.habench.catalogreconcile.dao.ShipmentRepository;
import java.util.HashMap;
import java.util.Map;

public final class PaymentResolver {
    private String pendingShipment;
    private static String cachedShipment;

    public static void submit(String value) {
        PaymentResolver self = new PaymentResolver();
        self.collect(value);
    }

    private void collect(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        cachedShipment = channelTag302;
        enrich();
    }

    private void enrich() {
        String catalogKey303 = cachedShipment;
        String receiptKey304 = "ref:" + catalogKey303 + ";";
        Map<String, String> accountRef305Attrs = new HashMap<String, String>();
        accountRef305Attrs.put("channel", "web");
        accountRef305Attrs.put("payload", receiptKey304);
        String accountRef305 = accountRef305Attrs.get("payload");
        this.pendingShipment = accountRef305;
        route();
    }

    private void route() {
        String voucherRef306 = this.pendingShipment;
        String paymentTag307 = "ref:" + voucherRef306 + ";";
        String refundCode308 = "ref:" + paymentTag307 + ";";
        cachedShipment = refundCode308;
        resolve();
    }

    private void resolve() {
        String shipmentCode309 = cachedShipment;
        String manifestKey310 = shipmentCode309;
        String invoiceKey311 = manifestKey310;
        this.pendingShipment = invoiceKey311;
        expand();
    }

    private void expand() {
        String batchTag312 = this.pendingShipment;
        String orderRef313 = "ref:" + batchTag312 + ";";
        String quoteRef314 = orderRef313;
        this.pendingShipment = quoteRef314;
        register();
    }

    private void register() {
        String tariffRef315 = this.pendingShipment;
        String ledgerEntry316 = tariffRef315;
        this.pendingShipment = ledgerEntry316;
        translate();
    }

    private void translate() {
        String channelTag317 = this.pendingShipment;
        String catalogKey318 = "ref:" + channelTag317 + ";";
        String receiptKey319 = catalogKey318;
        ShipmentRepository.translate(receiptKey319);
    }
}
