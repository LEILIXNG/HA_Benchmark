package com.habench.catalogreopen.service;

import com.habench.catalogreopen.service.SessionRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffFacade {
    private String pendingSession;

    public static void merge(String value) {
        TariffFacade self = new TariffFacade();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        this.pendingSession = shipmentCode201;
        reconcile();
    }

    private void reconcile() {
        String manifestKey202 = this.pendingSession;
        String invoiceKey203 = "ref:" + manifestKey202 + ";";
        SessionRepository.stage(invoiceKey203);
    }
}
