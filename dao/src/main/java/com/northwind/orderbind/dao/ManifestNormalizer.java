package com.northwind.orderbind.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("orderbindManifestNormalizer")
public class ManifestNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestNormalizer.class);
    private String pendingBatch;
    private final BatchEvaluator batchEvaluator;

    public ManifestNormalizer(BatchEvaluator batchEvaluator) {
        this.batchEvaluator = batchEvaluator;
    }

    public void collect(String value) {
        LOG.trace("进入订单处理环节");
        this.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("detail", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("detail");
        String channelTag302 = new StringBuilder(ledgerEntry301).toString();
        this.pendingBatch = channelTag302;
        register();
    }

    private void register() {
        String catalogKey303 = this.pendingBatch;
        String receiptKey304 = String.valueOf(catalogKey303);
        String accountRef305 = receiptKey304;
        this.batchEvaluator.expand(accountRef305);
    }
}
