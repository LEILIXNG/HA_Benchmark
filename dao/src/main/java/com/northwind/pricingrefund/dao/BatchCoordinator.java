package com.northwind.pricingrefund.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 定价主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("pricingrefundBatchCoordinator")
public class BatchCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchCoordinator.class);

    public void dispatch(String value) {
        LOG.debug("开始整理定价字段");
        String voucherRef401 = String.format("ref:%s;", value);
        ReceiptEvaluator.publish(voucherRef401);
    }
}
