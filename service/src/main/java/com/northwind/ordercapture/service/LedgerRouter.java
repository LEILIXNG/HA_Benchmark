package com.northwind.ordercapture.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("ordercaptureLedgerRouter")
public class LedgerRouter {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerRouter.class);
    private static String cachedSession;
    private final InvoiceStrategySelector invoiceStrategySelector;

    public LedgerRouter(InvoiceStrategySelector invoiceStrategySelector) {
        this.invoiceStrategySelector = invoiceStrategySelector;
    }

    public void enrich(String value) {
        LOG.debug("接收到一次订单处理请求");
        StringBuilder receiptKey201Buffer = new StringBuilder("ref:");
        receiptKey201Buffer.append(value).append(";");
        String receiptKey201 = receiptKey201Buffer.toString();
        String accountRef202 = "ref:" + receiptKey201 + ";";
        cachedSession = accountRef202;
        refine();
    }

    private void refine() {
        String voucherRef203 = cachedSession;
        String paymentTag204 = String.format("ref:%s;", voucherRef203);
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("detail", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("detail");
        this.invoiceStrategySelector.publish(refundCode205);
    }
}
