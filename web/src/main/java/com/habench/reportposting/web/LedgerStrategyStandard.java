package com.habench.reportposting.web;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        ChannelFacade.reconcile(value);
    }
}
