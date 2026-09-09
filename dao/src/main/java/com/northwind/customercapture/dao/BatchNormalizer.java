package com.northwind.customercapture.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("customercaptureBatchNormalizer")
public class BatchNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(BatchNormalizer.class);
    private final ReceiptNormalizer receiptNormalizer;

    public BatchNormalizer(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    public void submit(String value) {
        LOG.debug("接收到一次客户处理请求");
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("detail", value);
        String invoiceKey301 = invoiceKey301Attrs.get("detail");
        String batchTag302 = invoiceKey301;
        this.receiptNormalizer.attach(batchTag302);
    }
}
