package com.habench.customermerge.web;

import com.habench.customermerge.service.OrderFacade;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {
    private String pendingAccount;
    private static String cachedAccount;

    public static void resolve(String value) {
        OrderService self = new OrderService();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        cachedAccount = ledgerEntry102;
        assemble();
    }

    private void assemble() {
        String channelTag103 = cachedAccount;
        String catalogKey104 = channelTag103;
        Map<String, String> receiptKey105Attrs = new HashMap<String, String>();
        receiptKey105Attrs.put("channel", "web");
        receiptKey105Attrs.put("payload", catalogKey104);
        String receiptKey105 = receiptKey105Attrs.get("payload");
        this.pendingAccount = receiptKey105;
        merge();
    }

    private void merge() {
        String accountRef106 = this.pendingAccount;
        String voucherRef107 = accountRef106;
        String paymentTag108 = voucherRef107;
        OrderFacade.register(paymentTag108);
    }
}
