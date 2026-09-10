package com.northwind.accountintake.service;

import com.northwind.accountintake.dao.QuoteResolver;
import org.springframework.stereotype.Service;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("accountintakeChannelTranslator")
public class ChannelTranslator {
    private final QuoteResolver quoteResolver;

    public ChannelTranslator(QuoteResolver quoteResolver) {
        this.quoteResolver = quoteResolver;
    }

    public void translate(String value) {
        String catalogKey101 = String.format("ref_%s", value);
        String receiptKey102 = String.valueOf(catalogKey101);
        this.quoteResolver.enrich(receiptKey102);
    }
}
