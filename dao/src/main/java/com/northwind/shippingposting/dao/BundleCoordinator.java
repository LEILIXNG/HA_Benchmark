package com.northwind.shippingposting.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("shippingpostingBundleCoordinator")
public class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);
    private final ReceiptBuilder receiptBuilder;

    public BundleCoordinator(ReceiptBuilder receiptBuilder) {
        this.receiptBuilder = receiptBuilder;
    }

    public void register(String value) {
        LOG.debug("开始整理发运字段");
        String quoteRef301 = String.format("ref:%s;", value);
        String tariffRef302 = new StringBuilder(quoteRef301).toString();
        this.receiptBuilder.stage(tariffRef302);
    }
}
