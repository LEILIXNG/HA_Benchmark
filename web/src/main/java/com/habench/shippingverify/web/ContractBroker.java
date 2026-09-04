package com.habench.shippingverify.web;

import com.habench.shippingverify.service.OrderResolver;
import java.util.HashMap;
import java.util.Map;

public final class ContractBroker {
    private String pendingOrder;

    public static void compose(String value) {
        ContractBroker self = new ContractBroker();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        this.pendingOrder = ledgerEntry101;
        assemble();
    }

    private void assemble() {
        String channelTag102 = this.pendingOrder;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("payload", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("payload");
        this.pendingOrder = catalogKey103;
        normalize();
    }

    private void normalize() {
        String receiptKey104 = this.pendingOrder;
        Map<String, String> accountRef105Attrs = new HashMap<String, String>();
        accountRef105Attrs.put("channel", "web");
        accountRef105Attrs.put("payload", receiptKey104);
        String accountRef105 = accountRef105Attrs.get("payload");
        Map<String, String> voucherRef106Attrs = new HashMap<String, String>();
        voucherRef106Attrs.put("channel", "web");
        voucherRef106Attrs.put("payload", accountRef105);
        String voucherRef106 = voucherRef106Attrs.get("payload");
        OrderResolver.register(voucherRef106);
    }
}
