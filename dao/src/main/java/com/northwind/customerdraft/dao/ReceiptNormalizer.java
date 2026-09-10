package com.northwind.customerdraft.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("customerdraftReceiptNormalizer")
public class ReceiptNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptNormalizer.class);
    private final OrderBuilder orderBuilder;

    public ReceiptNormalizer(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public void compose(String value) {
        LOG.debug("开始整理客户字段");
        StringBuilder catalogKey501Buffer = new StringBuilder("ref_");
        catalogKey501Buffer.append(value);
        String catalogKey501 = catalogKey501Buffer.toString();
        String receiptKey502 = new StringBuilder(catalogKey501).toString();
        this.orderBuilder.stage(receiptKey502);
    }
}
