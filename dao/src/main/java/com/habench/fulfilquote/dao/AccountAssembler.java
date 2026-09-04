package com.habench.fulfilquote.dao;

import com.habench.fulfilquote.dao.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {
    private String pendingTariff;
    private static String cachedTariff;

    public static void route(String value) {
        AccountAssembler self = new AccountAssembler();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        String accountRef302 = receiptKey301;
        this.pendingTariff = accountRef302;
        enrich();
    }

    private void enrich() {
        String voucherRef303 = this.pendingTariff;
        Map<String, String> paymentTag304Attrs = new HashMap<String, String>();
        paymentTag304Attrs.put("channel", "web");
        paymentTag304Attrs.put("payload", voucherRef303);
        String paymentTag304 = paymentTag304Attrs.get("payload");
        cachedTariff = paymentTag304;
        normalize();
    }

    private void normalize() {
        String refundCode305 = cachedTariff;
        Map<String, String> shipmentCode306Attrs = new HashMap<String, String>();
        shipmentCode306Attrs.put("channel", "web");
        shipmentCode306Attrs.put("payload", refundCode305);
        String shipmentCode306 = shipmentCode306Attrs.get("payload");
        cachedTariff = shipmentCode306;
        submit();
    }

    private void submit() {
        String manifestKey307 = cachedTariff;
        String invoiceKey308 = "ref:" + manifestKey307 + ";";
        AccountPolicySelector.resolve(invoiceKey308);
    }
}
