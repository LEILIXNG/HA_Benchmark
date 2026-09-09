package com.northwind.accountimport.service;

import org.springframework.stereotype.Service;

/**
 * 账户的默认处理策略。
 */
@Service("accountimportBatchStrategyStandard")
public class BatchStrategyStandard implements BatchStrategy {
    private final ManifestCollector manifestCollector;

    public BatchStrategyStandard(ManifestCollector manifestCollector) {
        this.manifestCollector = manifestCollector;
    }

    @Override
    public void handle(String value) {
        this.manifestCollector.normalize(value);
    }
}
