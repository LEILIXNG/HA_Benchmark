package com.northwind.fulfilcapture.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
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
        ledgerEntry203Attrs.put("note", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.get("note");
        ContractCoordinator.route(ledgerEntry203);
    }
}
