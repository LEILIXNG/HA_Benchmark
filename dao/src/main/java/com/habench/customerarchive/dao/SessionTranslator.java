package com.habench.customerarchive.dao;

import com.habench.customerarchive.dao.SessionExecutor;
import java.util.HashMap;
import java.util.Map;

public final class SessionTranslator {

    public static void compose(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        SessionExecutor.reconcile(orderRef301);
    }
}
