package com.habench.vendorreopen.service;

public final class SessionStrategyStandard implements SessionStrategy {
    @Override
    public void handle(String value) {
        TariffFacade.dispatch(value);
    }
}
