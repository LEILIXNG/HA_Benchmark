package com.habench.accountposting.web;

import com.habench.accountposting.service.TariffCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingTariff;

    public static void resolve(String value) {
        TariffEnricher self = new TariffEnricher();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        this.pendingTariff = quoteRef2;
        assemble();
    }

    private void assemble() {
        String tariffRef3 = this.pendingTariff;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        this.pendingTariff = channelTag5;
        forward();
    }

    private void forward() {
        String catalogKey6 = this.pendingTariff;
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        Map<String, String> accountRef8Attrs = new HashMap<String, String>();
        accountRef8Attrs.put("channel", "web");
        accountRef8Attrs.put("payload", receiptKey7);
        String accountRef8 = accountRef8Attrs.get("payload");
        TariffCoordinator.reconcile(accountRef8);
    }
}
