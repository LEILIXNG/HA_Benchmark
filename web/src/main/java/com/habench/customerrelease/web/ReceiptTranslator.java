package com.habench.customerrelease.web;

import com.habench.customerrelease.web.QuoteValidator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptTranslator {
    private String pendingTariff;

    public static void stage(String value) {
        ReceiptTranslator self = new ReceiptTranslator();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        this.pendingTariff = tariffRef301;
        assemble();
    }

    private void assemble() {
        String ledgerEntry302 = this.pendingTariff;
        String channelTag303 = "ref:" + ledgerEntry302 + ";";
        QuoteValidator.publish(channelTag303);
    }
}
