package com.habench.shippingtransfer.web;

import com.habench.shippingtransfer.web.AccountPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionEnricher {
    private String pendingContract;

    public static void compose(String value) {
        SessionEnricher self = new SessionEnricher();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        this.pendingContract = tariffRef1;
        forward();
    }

    private void forward() {
        String ledgerEntry2 = this.pendingContract;
        String channelTag3 = ledgerEntry2;
        Map<String, String> catalogKey4Attrs = new HashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("payload", channelTag3);
        String catalogKey4 = catalogKey4Attrs.get("payload");
        this.pendingContract = catalogKey4;
        attach();
    }

    private void attach() {
        String receiptKey5 = this.pendingContract;
        Map<String, String> accountRef6Attrs = new HashMap<String, String>();
        accountRef6Attrs.put("channel", "web");
        accountRef6Attrs.put("payload", receiptKey5);
        String accountRef6 = accountRef6Attrs.get("payload");
        String voucherRef7 = accountRef6;
        AccountPlanSelector.attach(voucherRef7);
    }
}
