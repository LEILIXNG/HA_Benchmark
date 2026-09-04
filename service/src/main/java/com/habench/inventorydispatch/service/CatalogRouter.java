package com.habench.inventorydispatch.service;

import com.habench.inventorydispatch.dao.ContractNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private String pendingPayment;

    public static void translate(String value) {
        CatalogRouter self = new CatalogRouter();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        this.pendingPayment = orderRef301;
        expand();
    }

    private void expand() {
        String quoteRef302 = this.pendingPayment;
        String tariffRef303 = "ref:" + quoteRef302 + ";";
        String ledgerEntry304 = tariffRef303;
        this.pendingPayment = ledgerEntry304;
        stage();
    }

    private void stage() {
        String channelTag305 = this.pendingPayment;
        String catalogKey306 = channelTag305;
        this.pendingPayment = catalogKey306;
        normalize();
    }

    private void normalize() {
        String receiptKey307 = this.pendingPayment;
        String accountRef308 = receiptKey307;
        Map<String, String> voucherRef309Attrs = new HashMap<String, String>();
        voucherRef309Attrs.put("channel", "web");
        voucherRef309Attrs.put("payload", accountRef308);
        String voucherRef309 = voucherRef309Attrs.get("payload");
        ContractNormalizer.dispatch(voucherRef309);
    }
}
