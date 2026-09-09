package com.habench.customeradjust.service;

import com.habench.customeradjust.dao.ContractAssembler;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {
    private String pendingTariff;
    private static String cachedTariff;

    public static void resolve(String value) {
        VoucherComposer self = new VoucherComposer();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        String channelTag102 = "ref:" + ledgerEntry101 + ";";
        cachedTariff = channelTag102;
        collect();
    }

    private void collect() {
        String catalogKey103 = cachedTariff;
        String receiptKey104 = catalogKey103;
        String accountRef105 = "ref:" + receiptKey104 + ";";
        this.pendingTariff = accountRef105;
        enrich();
    }

    private void enrich() {
        String voucherRef106 = this.pendingTariff;
        String paymentTag107 = voucherRef106;
        String refundCode108 = "ref:" + paymentTag107 + ";";
        ContractAssembler.enrich(refundCode108);
    }
}
