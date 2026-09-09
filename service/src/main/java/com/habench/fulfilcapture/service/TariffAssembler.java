package com.habench.fulfilcapture.service;

import com.habench.fulfilcapture.service.SessionCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffAssembler {

    public static void attach(String value) {
        String receiptKey101 = "ref:" + value + ";";
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        SessionCoordinator.publish(accountRef102);
    }
}
