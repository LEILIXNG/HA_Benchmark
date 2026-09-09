package com.northwind.catalogtransfer.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("catalogtransferChannelAdapter")
public class ChannelAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelAdapter.class);
    private final RefundRuleSelector refundRuleSelector;

    public ChannelAdapter(RefundRuleSelector refundRuleSelector) {
        this.refundRuleSelector = refundRuleSelector;
    }

    public void refine(String value) {
        LOG.debug("商品流程转下一环节");
        Map<String, String> manifestKey1Attrs = new LinkedHashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("detail", value);
        String manifestKey1 = manifestKey1Attrs.getOrDefault("detail", "");
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("remark", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("remark");
        this.refundRuleSelector.attach(invoiceKey2);
    }
}
