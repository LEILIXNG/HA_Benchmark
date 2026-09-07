package com.habench.vendorreopen.web;

public final class SessionStrategyStandard implements SessionStrategy {
    @Override
    public void handle(String value) {
        SessionCoordinator.resolve(value);
    }
}
