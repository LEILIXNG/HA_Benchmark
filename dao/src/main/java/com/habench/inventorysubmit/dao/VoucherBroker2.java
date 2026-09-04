package com.habench.inventorysubmit.dao;

import com.habench.inventorysubmit.dao.LedgerAssembler;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker2 {
    private String pendingShipment;

    public static void collect(String value) {
        VoucherBroker2 self = new VoucherBroker2();
        self.prepare(value);
    }

    private void prepare(String value) {
        String batchTag201 = "ref:" + value + ";";
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("payload", batchTag201);
        String orderRef202 = orderRef202Attrs.get("payload");
        this.pendingShipment = orderRef202;
        dispatch();
    }

    private void dispatch() {
        String quoteRef203 = this.pendingShipment;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        LedgerAssembler.normalize(tariffRef204);
    }
}
