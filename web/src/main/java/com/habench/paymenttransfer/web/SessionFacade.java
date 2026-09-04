package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionFacade {
    private String pendingLedger;

    public static void dispatch(String value) {
        SessionFacade self = new SessionFacade();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        this.pendingLedger = tariffRef1;
        route();
    }

    private void route() {
        String ledgerEntry2 = this.pendingLedger;
        String channelTag3 = ledgerEntry2;
        String catalogKey4 = channelTag3;
        ShipmentStrategySelector.prepare(catalogKey4);
    }
}
