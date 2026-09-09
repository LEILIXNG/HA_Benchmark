package com.northwind.inventoryreopen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("inventoryreopenTariffAssembler")
public class TariffAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(TariffAssembler.class);
    private final ContractPlanSelector contractPlanSelector;

    public TariffAssembler(ContractPlanSelector contractPlanSelector) {
        this.contractPlanSelector = contractPlanSelector;
    }

    public void register(String value) {
        LOG.debug("接收到一次库存处理请求");
        String catalogKey101 = String.valueOf(value);
        this.contractPlanSelector.collect(catalogKey101);
    }
}
