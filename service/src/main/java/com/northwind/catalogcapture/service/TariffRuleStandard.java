package com.northwind.catalogcapture.service;

import org.springframework.stereotype.Service;

/**
 * 商品的默认处理策略。
 */
@Service("catalogcaptureTariffRuleStandard")
public class TariffRuleStandard implements TariffRule {
    private final LedgerTranslator ledgerTranslator;

    public TariffRuleStandard(LedgerTranslator ledgerTranslator) {
        this.ledgerTranslator = ledgerTranslator;
    }

    @Override
    public void handle(String value) {
        this.ledgerTranslator.translate(value);
    }
}
