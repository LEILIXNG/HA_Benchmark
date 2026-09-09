package com.northwind.vendorsync.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BatchFacade {
    private static final Logger LOG = LoggerFactory.getLogger(BatchFacade.class);
    private String pendingBatch;

    public static void forward(String value) {
        LOG.debug("供应商流程转下一环节");
        BatchFacade self = new BatchFacade();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> accountRef501Attrs = new LinkedHashMap<String, String>();
        accountRef501Attrs.put("channel", "web");
        accountRef501Attrs.put("detail", value);
        String accountRef501 = accountRef501Attrs.getOrDefault("detail", "");
        final String voucherRef502 = accountRef501;
        this.pendingBatch = voucherRef502;
        collect();
    }

    private void collect() {
        String paymentTag503 = this.pendingBatch;
        Map<String, String> refundCode504Attrs = new HashMap<String, String>();
        refundCode504Attrs.put("channel", "web");
        refundCode504Attrs.put("reference", paymentTag503);
        String refundCode504 = refundCode504Attrs.get("reference");
        Map<String, String> shipmentCode505Attrs = new LinkedHashMap<String, String>();
        shipmentCode505Attrs.put("channel", "web");
        shipmentCode505Attrs.put("detail", refundCode504);
        String shipmentCode505 = shipmentCode505Attrs.getOrDefault("detail", "");
        BatchExecutor.assemble(shipmentCode505);
    }
}
