package com.northwind.shippingclose.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("shippingcloseVoucherRouter")
public class VoucherRouter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRouter.class);
    private final InvoiceRouter invoiceRouter;

    public VoucherRouter(InvoiceRouter invoiceRouter) {
        this.invoiceRouter = invoiceRouter;
    }

    public void forward(String value) {
        LOG.debug("发运流程转下一环节");
        String batchTag1 = value;
        StringBuilder orderRef2Buffer = new StringBuilder("ref_");
        orderRef2Buffer.append(batchTag1);
        String orderRef2 = orderRef2Buffer.toString();
        this.invoiceRouter.attach(orderRef2);
    }
}
