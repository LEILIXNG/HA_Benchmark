package com.habench.vendorquote.dao;

import com.habench.vendorquote.dao.VoucherRepository;
import java.util.HashMap;
import java.util.Map;

public final class QuoteService {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void compose(String value) {
        QuoteService self = new QuoteService();
        self.attach(value);
    }

    private void attach(String value) {
        String receiptKey401 = "ref:" + value + ";";
        Map<String, String> accountRef402Attrs = new HashMap<String, String>();
        accountRef402Attrs.put("channel", "web");
        accountRef402Attrs.put("payload", receiptKey401);
        String accountRef402 = accountRef402Attrs.get("payload");
        cachedVoucher = accountRef402;
        collect();
    }

    private void collect() {
        String voucherRef403 = cachedVoucher;
        String paymentTag404 = "ref:" + voucherRef403 + ";";
        this.pendingVoucher = paymentTag404;
        stage();
    }

    private void stage() {
        String refundCode405 = this.pendingVoucher;
        String shipmentCode406 = "ref:" + refundCode405 + ";";
        String manifestKey407 = "ref:" + shipmentCode406 + ";";
        VoucherRepository.reconcile(manifestKey407);
    }
}
