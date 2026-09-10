package com.northwind.ordersubmit.web;

import com.northwind.ordersubmit.service.ReceiptResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("ordersubmitBundleCollector")
public class BundleCollector {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCollector.class);
    private final ReceiptResolver receiptResolver;

    public BundleCollector(ReceiptResolver receiptResolver) {
        this.receiptResolver = receiptResolver;
    }

    public void reconcile(String value) {
        LOG.debug("订单流程转下一环节");
        String catalogKey1 = value;
        StringBuilder receiptKey2Buffer = new StringBuilder("ref_");
        receiptKey2Buffer.append(catalogKey1);
        String receiptKey2 = receiptKey2Buffer.toString();
        this.receiptResolver.register(receiptKey2);
    }
}
