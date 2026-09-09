package com.northwind.customerapprove.service;

import org.springframework.stereotype.Service;

/**
 * 客户的默认处理策略。
 */
@Service("customerapproveTariffStrategyStandard")
public class TariffStrategyStandard implements TariffStrategy {
    private final SessionAssembler sessionAssembler;

    public TariffStrategyStandard(SessionAssembler sessionAssembler) {
        this.sessionAssembler = sessionAssembler;
    }

    @Override
    public void handle(String value) {
        this.sessionAssembler.dispatch(value);
    }
}
