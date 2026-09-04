package com.habench.customerhold.web;

import com.habench.customerhold.web.SessionRouter;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {

    public static void reconcile(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        SessionRouter.merge(receiptKey101);
    }
}
