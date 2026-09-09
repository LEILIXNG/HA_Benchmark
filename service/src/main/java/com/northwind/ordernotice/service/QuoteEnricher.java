package com.northwind.ordernotice.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("ordernoticeQuoteEnricher")
public class QuoteEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteEnricher.class);
    private final InvoicePolicySelector invoicePolicySelector;

    public QuoteEnricher(InvoicePolicySelector invoicePolicySelector) {
        this.invoicePolicySelector = invoicePolicySelector;
    }

    public void publish(String value) {
        LOG.debug("开始整理订单字段");
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("detail", value);
        String channelTag101 = channelTag101Attrs.get("detail");
        this.invoicePolicySelector.dispatch(channelTag101);
    }
}
