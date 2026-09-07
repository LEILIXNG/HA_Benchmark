package com.habench.accountimport.service;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        ManifestCollector.normalize(value);
    }
}
