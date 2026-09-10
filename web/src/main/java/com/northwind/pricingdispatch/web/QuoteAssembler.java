package com.northwind.pricingdispatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingdispatchQuoteAssembler")
public class QuoteAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteAssembler.class);
    private String pendingAccount;
    private static String cachedAccount;

    public void forward(String value) {
        LOG.debug("接收到一次定价处理请求");
        this.attach(value);
    }

    private void attach(String value) {
        StringBuilder manifestKey1Buffer = new StringBuilder("ref_");
        manifestKey1Buffer.append(value);
        String manifestKey1 = manifestKey1Buffer.toString();
        String invoiceKey2 = "ref_" + manifestKey1;
        this.pendingAccount = invoiceKey2;
        normalize();
    }

    private void normalize() {
        String batchTag3 = this.pendingAccount;
        String orderRef4 = String.format("ref_%s", batchTag3);
        String quoteRef5 = "ref_".concat(orderRef4);
        cachedAccount = quoteRef5;
        submit();
    }

    private void submit() {
        String tariffRef6 = cachedAccount;
        String ledgerEntry7 = new StringBuilder(tariffRef6).toString();
        StringBuilder channelTag8Buffer = new StringBuilder("ref_");
        channelTag8Buffer.append(ledgerEntry7);
        String channelTag8 = channelTag8Buffer.toString();
        BundleComposer.resolve(channelTag8);
    }
}
