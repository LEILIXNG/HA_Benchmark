package com.habench.reportexport.service;

import com.habench.reportexport.service.QuoteRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionNormalizer {
    private String pendingRefund;

    public static void merge(String value) {
        SessionNormalizer self = new SessionNormalizer();
        self.publish(value);
    }

    private void publish(String value) {
        String batchTag101 = "ref:" + value + ";";
        this.pendingRefund = batchTag101;
        dispatch();
    }

    private void dispatch() {
        String orderRef102 = this.pendingRefund;
        String quoteRef103 = "ref:" + orderRef102 + ";";
        Map<String, String> tariffRef104Attrs = new HashMap<String, String>();
        tariffRef104Attrs.put("channel", "web");
        tariffRef104Attrs.put("payload", quoteRef103);
        String tariffRef104 = tariffRef104Attrs.get("payload");
        QuoteRuleSelector.compose(tariffRef104);
    }
}
