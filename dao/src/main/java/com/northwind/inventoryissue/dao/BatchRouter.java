package com.northwind.inventoryissue.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("inventoryissueBatchRouter")
public class BatchRouter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRouter.class);
    private final OrderAssembler orderAssembler;

    public BatchRouter(OrderAssembler orderAssembler) {
        this.orderAssembler = orderAssembler;
    }

    public void assemble(String value) {
        LOG.debug("开始整理库存字段");
        String voucherRef401 = String.format("ref_%s", value);
        this.orderAssembler.translate(voucherRef401);
    }
}
