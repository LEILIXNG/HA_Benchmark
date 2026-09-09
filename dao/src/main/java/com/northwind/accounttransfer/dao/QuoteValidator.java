package com.northwind.accounttransfer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向账户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("accounttransferQuoteValidator")
public class QuoteValidator {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteValidator.class);
    private final ChannelEvaluator channelEvaluator;

    public QuoteValidator(ChannelEvaluator channelEvaluator) {
        this.channelEvaluator = channelEvaluator;
    }

    public void assemble(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.channelEvaluator.forward(value);
    }
}
