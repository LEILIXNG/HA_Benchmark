package com.habench.vendorsync.service;

import com.habench.vendorsync.service.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {
    private String pendingBatch;

    public static void forward(String value) {
        BatchFacade self = new BatchFacade();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> accountRef501Attrs = new HashMap<String, String>();
        accountRef501Attrs.put("channel", "web");
        accountRef501Attrs.put("payload", value);
        String accountRef501 = accountRef501Attrs.get("payload");
        String voucherRef502 = accountRef501;
        this.pendingBatch = voucherRef502;
        collect();
    }

    private void collect() {
        String paymentTag503 = this.pendingBatch;
        Map<String, String> refundCode504Attrs = new HashMap<String, String>();
        refundCode504Attrs.put("channel", "web");
        refundCode504Attrs.put("payload", paymentTag503);
        String refundCode504 = refundCode504Attrs.get("payload");
        Map<String, String> shipmentCode505Attrs = new HashMap<String, String>();
        shipmentCode505Attrs.put("channel", "web");
        shipmentCode505Attrs.put("payload", refundCode504);
        String shipmentCode505 = shipmentCode505Attrs.get("payload");
        BatchExecutor.assemble(shipmentCode505);
    }
}
