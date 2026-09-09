package com.northwind.paymentgrant.web;

import com.northwind.paymentgrant.service.InvoiceFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ReceiptTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptTranslator.class);

    public static void forward(String value) {
        LOG.debug("接收到一次支付处理请求");
        String quoteRef1 = "ref:".concat(value).concat(";");
        InvoiceFacade.compose(quoteRef1);
    }
}
