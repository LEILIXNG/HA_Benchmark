package com.northwind.inventorybatch.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("inventorybatchBatchTranslator")
public class BatchTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchTranslator.class);
    private final BatchPlanSelector batchPlanSelector;

    public BatchTranslator(BatchPlanSelector batchPlanSelector) {
        this.batchPlanSelector = batchPlanSelector;
    }

    public void forward(String value) {
        LOG.debug("开始整理库存字段");
        String catalogKey301 = "ref_" + value;
        StringBuilder receiptKey302Buffer = new StringBuilder("ref_");
        receiptKey302Buffer.append(catalogKey301);
        String receiptKey302 = receiptKey302Buffer.toString();
        this.batchPlanSelector.refine(receiptKey302);
    }
}
