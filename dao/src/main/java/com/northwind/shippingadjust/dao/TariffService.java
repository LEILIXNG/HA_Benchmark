package com.northwind.shippingadjust.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("shippingadjustTariffService")
public class TariffService {
    private static final Logger LOG = LoggerFactory.getLogger(TariffService.class);
    private final ContractEvaluator contractEvaluator;

    public TariffService(ContractEvaluator contractEvaluator) {
        this.contractEvaluator = contractEvaluator;
    }

    public void submit(String value) {
        LOG.debug("发运流程转下一环节");
        String voucherRef301 = "ref_".concat(value);
        this.contractEvaluator.attach(voucherRef301);
    }
}
