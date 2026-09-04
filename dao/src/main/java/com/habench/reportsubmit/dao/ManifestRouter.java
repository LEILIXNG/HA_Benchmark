package com.habench.reportsubmit.dao;

import com.habench.reportsubmit.dao.SessionRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {

    public static void collect(String value) {
        Map<String, String> shipmentCode501Attrs = new HashMap<String, String>();
        shipmentCode501Attrs.put("channel", "web");
        shipmentCode501Attrs.put("payload", value);
        String shipmentCode501 = shipmentCode501Attrs.get("payload");
        String manifestKey502 = shipmentCode501;
        SessionRepository.reconcile(manifestKey502);
    }
}
