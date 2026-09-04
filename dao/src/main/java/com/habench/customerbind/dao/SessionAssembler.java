package com.habench.customerbind.dao;

import com.habench.customerbind.dao.VoucherRepository;
import java.util.HashMap;
import java.util.Map;

public final class SessionAssembler {
    private static String cachedVoucher;

    public static void merge(String value) {
        String receiptKey501 = value;
        cachedVoucher = receiptKey501;
        attach();
    }

    private static void attach() {
        String accountRef502 = cachedVoucher;
        String voucherRef503 = "ref:" + accountRef502 + ";";
        Map<String, String> paymentTag504Attrs = new HashMap<String, String>();
        paymentTag504Attrs.put("channel", "web");
        paymentTag504Attrs.put("payload", voucherRef503);
        String paymentTag504 = paymentTag504Attrs.get("payload");
        cachedVoucher = paymentTag504;
        refine();
    }

    private static void refine() {
        String refundCode505 = cachedVoucher;
        Map<String, String> shipmentCode506Attrs = new HashMap<String, String>();
        shipmentCode506Attrs.put("channel", "web");
        shipmentCode506Attrs.put("payload", refundCode505);
        String shipmentCode506 = shipmentCode506Attrs.get("payload");
        cachedVoucher = shipmentCode506;
        assemble();
    }

    private static void assemble() {
        String manifestKey507 = cachedVoucher;
        String invoiceKey508 = "ref:" + manifestKey507 + ";";
        VoucherRepository.refine(invoiceKey508);
    }
}
