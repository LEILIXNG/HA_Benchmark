package com.habench.customergrant.dao;

import com.habench.customergrant.dao.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {
    private String pendingTariff;
    private static String cachedTariff;

    public static void forward(String value) {
        AccountService self = new AccountService();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag201 = value;
        this.pendingTariff = channelTag201;
        expand();
    }

    private void expand() {
        String catalogKey202 = this.pendingTariff;
        Map<String, String> receiptKey203Attrs = new HashMap<String, String>();
        receiptKey203Attrs.put("channel", "web");
        receiptKey203Attrs.put("payload", catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get("payload");
        cachedTariff = receiptKey203;
        merge();
    }

    private void merge() {
        String accountRef204 = cachedTariff;
        String voucherRef205 = "ref:" + accountRef204 + ";";
        this.pendingTariff = voucherRef205;
        reconcile();
    }

    private void reconcile() {
        String paymentTag206 = this.pendingTariff;
        String refundCode207 = "ref:" + paymentTag206 + ";";
        Map<String, String> shipmentCode208Attrs = new HashMap<String, String>();
        shipmentCode208Attrs.put("channel", "web");
        shipmentCode208Attrs.put("payload", refundCode207);
        String shipmentCode208 = shipmentCode208Attrs.get("payload");
        cachedTariff = shipmentCode208;
        dispatch();
    }

    private void dispatch() {
        String manifestKey209 = cachedTariff;
        String invoiceKey210 = manifestKey209;
        String batchTag211 = invoiceKey210;
        TariffRepository.route(batchTag211);
    }
}
