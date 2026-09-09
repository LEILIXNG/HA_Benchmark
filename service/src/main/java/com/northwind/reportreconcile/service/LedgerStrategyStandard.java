package com.northwind.reportreconcile.service;

import org.springframework.stereotype.Service;

/**
 * 报表的默认处理策略。
 */
@Service("reportreconcileLedgerStrategyStandard")
public class LedgerStrategyStandard implements LedgerStrategy {
    private final QuoteComposer quoteComposer;

    public LedgerStrategyStandard(QuoteComposer quoteComposer) {
        this.quoteComposer = quoteComposer;
    }

    @Override
    public void handle(String value) {
        this.quoteComposer.translate(value);
    }
}
