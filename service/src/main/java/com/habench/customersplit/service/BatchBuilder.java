package com.habench.customersplit.service;

import com.habench.customersplit.dao.BundleFacade;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {

    public static void forward(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        Map<String, String> tariffRef202Attrs = new HashMap<String, String>();
        tariffRef202Attrs.put("channel", "web");
        tariffRef202Attrs.put("payload", quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get("payload");
        BundleFacade.submit(tariffRef202);
    }
}
