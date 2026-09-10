package com.northwind.billingsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billingsyncLedgerBroker")
public class LedgerBroker {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerBroker.class);

    public void enrich(String value) {
        LOG.debug("开始整理账务字段");
        String catalogKey201 = value;
        String receiptKey202 = "ref_".concat(catalogKey201);
        BundleEnricher.assemble(receiptKey202);
    }
}
