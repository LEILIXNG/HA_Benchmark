package com.northwind.catalogtrace.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 商品处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("catalogtraceSessionTranslator")
public class SessionTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(SessionTranslator.class);
    private final ShipmentExecutor shipmentExecutor;

    public SessionTranslator(ShipmentExecutor shipmentExecutor) {
        this.shipmentExecutor = shipmentExecutor;
    }

    public void submit(String value) {
        LOG.debug("商品流程转下一环节");
        Map<String, String> batchTag201Attrs = new LinkedHashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("detail", value);
        String batchTag201 = batchTag201Attrs.getOrDefault("detail", "");
        this.shipmentExecutor.translate(batchTag201);
    }
}
