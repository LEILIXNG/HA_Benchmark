package com.habench.customersplit.dao;

import com.habench.customersplit.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleFacade {
    private String pendingOrder;

    public static void submit(String value) {
        BundleFacade self = new BundleFacade();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        this.pendingOrder = manifestKey302;
        prepare();
    }

    private void prepare() {
        String invoiceKey303 = this.pendingOrder;
        String batchTag304 = "ref:" + invoiceKey303 + ";";
        this.pendingOrder = batchTag304;
        reconcile();
    }

    private void reconcile() {
        String orderRef305 = this.pendingOrder;
        String quoteRef306 = orderRef305;
        this.pendingOrder = quoteRef306;
        stage();
    }

    private void stage() {
        String tariffRef307 = this.pendingOrder;
        String ledgerEntry308 = "ref:" + tariffRef307 + ";";
        OrderRepository.collect(ledgerEntry308);
    }
}
