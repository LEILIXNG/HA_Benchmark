package com.northwind.ordersettlequeue.web;

import com.northwind.ordersettlequeue.service.InvoiceBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("ordersettlequeueReceiptComposer")
public class ReceiptComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptComposer.class);
    private final InvoiceBroker invoiceBroker;

    public ReceiptComposer(InvoiceBroker invoiceBroker) {
        this.invoiceBroker = invoiceBroker;
    }

    public void publish(String value) {
        LOG.debug("开始整理订单字段");
        String ledgerEntry1 = value;
        this.invoiceBroker.reconcile(ledgerEntry1);
    }
}
