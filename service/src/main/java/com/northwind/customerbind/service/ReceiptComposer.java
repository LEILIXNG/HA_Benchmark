package com.northwind.customerbind.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ReceiptComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptComposer.class);

    public static void merge(String value) {
        LOG.debug("接收到一次客户处理请求");
        String accountRef101 = "ref:" + value + ";";
        LedgerPolicySelector.reconcile(accountRef101);
    }
}
