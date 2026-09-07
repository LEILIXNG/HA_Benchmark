package com.habench.billingreopen.service;

import com.habench.billingreopen.dao.TariffTranslator;
import java.util.HashMap;
import java.util.Map;

public final class SessionNormalizer {
    private String pendingChannel;

    public static void normalize(String value) {
        SessionNormalizer self = new SessionNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        this.pendingChannel = orderRef301;
        attach();
    }

    private void attach() {
        String quoteRef302 = this.pendingChannel;
        Map<String, String> tariffRef303Attrs = new HashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("payload", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get("payload");
        String ledgerEntry304 = "ref:" + tariffRef303 + ";";
        TariffTranslator.publish(ledgerEntry304);
    }
}
