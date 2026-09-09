package com.northwind.billingrenewal.web;

import com.northwind.billingrenewal.service.ReceiptRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("billingrenewalReceiptComposer")
public class ReceiptComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptComposer.class);
    private final ReceiptRouter receiptRouter;

    public ReceiptComposer(ReceiptRouter receiptRouter) {
        this.receiptRouter = receiptRouter;
    }

    public void prepare(String value) {
        LOG.debug("开始整理账务字段");
        this.receiptRouter.forward(value);
    }
}
