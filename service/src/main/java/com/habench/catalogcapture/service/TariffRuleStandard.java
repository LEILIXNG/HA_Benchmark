package com.habench.catalogcapture.service;

public final class TariffRuleStandard implements TariffRule {
    @Override
    public void handle(String value) {
        LedgerTranslator.translate(value);
    }
}
