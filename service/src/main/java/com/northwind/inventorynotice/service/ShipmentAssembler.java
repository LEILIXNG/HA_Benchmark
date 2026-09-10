package com.northwind.inventorynotice.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentAssembler.class);
    private static String cachedBatch;

    public static void merge(String value) {
        LOG.debug("开始整理库存字段");
        List<String> ledgerEntry401Attrs = new ArrayList<String>();
        ledgerEntry401Attrs.add("web");
        ledgerEntry401Attrs.add(value);
        String ledgerEntry401 = ledgerEntry401Attrs.get(1);
        StringBuilder channelTag402Buffer = new StringBuilder("ref_");
        channelTag402Buffer.append(ledgerEntry401);
        String channelTag402 = channelTag402Buffer.toString();
        cachedBatch = channelTag402;
        register();
    }

    private static void register() {
        String catalogKey403 = cachedBatch;
        Map<String, String> receiptKey404Attrs = new LinkedHashMap<String, String>();
        receiptKey404Attrs.put("channel", "web");
        receiptKey404Attrs.put("reference", catalogKey403);
        String receiptKey404 = receiptKey404Attrs.getOrDefault("reference", "");
        BatchGateway.merge(receiptKey404);
    }
}
