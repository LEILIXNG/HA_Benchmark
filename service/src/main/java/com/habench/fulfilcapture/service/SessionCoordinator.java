package com.habench.fulfilcapture.service;

import com.habench.fulfilcapture.service.ContractCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {
    private String pendingTariff;

    public static void publish(String value) {
        SessionCoordinator self = new SessionCoordinator();
        self.assemble(value);
    }

    private void assemble(String value) {
        String quoteRef201 = "ref:" + value + ";";
        this.pendingTariff = quoteRef201;
        register();
    }

    private void register() {
        String tariffRef202 = this.pendingTariff;
        Map<String, String> ledgerEntry203Attrs = new HashMap<String, String>();
        ledgerEntry203Attrs.put("channel", "web");
        ledgerEntry203Attrs.put("payload", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.get("payload");
        ContractCoordinator.route(ledgerEntry203);
    }
}
