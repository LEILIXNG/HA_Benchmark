package com.northwind.orderrevise.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("orderreviseReceiptResolver")
public class ReceiptResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptResolver.class);
    private String pendingBundle;
    private final BundleExecutor bundleExecutor;

    public ReceiptResolver(BundleExecutor bundleExecutor) {
        this.bundleExecutor = bundleExecutor;
    }

    public void route(String value) {
        LOG.debug("接收到一次订单处理请求");
        this.forward(value);
    }

    private void forward(String value) {
        String orderRef101 = "ref:".concat(value).concat(";");
        String quoteRef102 = String.format("ref:%s;", orderRef101);
        this.pendingBundle = quoteRef102;
        assemble();
    }

    private void assemble() {
        String tariffRef103 = this.pendingBundle;
        Map<String, String> ledgerEntry104Attrs = new HashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("reference", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.get("reference");
        this.bundleExecutor.translate(ledgerEntry104);
    }
}
