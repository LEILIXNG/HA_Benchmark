package com.northwind.pricingarchive.web;

import com.northwind.pricingarchive.service.AccountTranslator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingarchiveQuoteRouter")
public class QuoteRouter {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteRouter.class);
    private final AccountTranslator accountTranslator;

    public QuoteRouter(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    public void publish(String value) {
        LOG.debug("开始整理定价字段");
        final String catalogKey1 = value;
        Map<String, String> receiptKey2Attrs = new LinkedHashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("remark", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.getOrDefault("remark", "");
        this.accountTranslator.expand(receiptKey2);
    }
}
