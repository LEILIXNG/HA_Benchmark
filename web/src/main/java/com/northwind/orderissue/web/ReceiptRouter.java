package com.northwind.orderissue.web;

import com.northwind.orderissue.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("orderissueReceiptRouter")
public class ReceiptRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptRouter.class);
    private final InvoiceService invoiceService;

    public ReceiptRouter(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void resolve(String value) {
        LOG.debug("订单流程转下一环节");
        final String paymentTag1 = value;
        String refundCode2 = new StringBuilder(paymentTag1).toString();
        this.invoiceService.refine(refundCode2);
    }
}
