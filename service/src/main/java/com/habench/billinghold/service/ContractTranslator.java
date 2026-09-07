package com.habench.billinghold.service;

import com.habench.billinghold.service.PaymentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void normalize(String value) {
        ContractTranslator self = new ContractTranslator();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        String ledgerEntry202 = tariffRef201;
        this.pendingReceipt = ledgerEntry202;
        register();
    }

    private void register() {
        String channelTag203 = this.pendingReceipt;
        String catalogKey204 = channelTag203;
        this.pendingReceipt = catalogKey204;
        dispatch();
    }

    private void dispatch() {
        String receiptKey205 = this.pendingReceipt;
        String accountRef206 = "ref:" + receiptKey205 + ";";
        String voucherRef207 = accountRef206;
        cachedReceipt = voucherRef207;
        assemble();
    }

    private void assemble() {
        String paymentTag208 = cachedReceipt;
        String refundCode209 = "ref:" + paymentTag208 + ";";
        Map<String, String> shipmentCode210Attrs = new HashMap<String, String>();
        shipmentCode210Attrs.put("channel", "web");
        shipmentCode210Attrs.put("payload", refundCode209);
        String shipmentCode210 = shipmentCode210Attrs.get("payload");
        PaymentPlanSelector.assemble(shipmentCode210);
    }
}
