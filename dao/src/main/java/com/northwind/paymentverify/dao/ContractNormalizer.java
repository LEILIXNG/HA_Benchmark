package com.northwind.paymentverify.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("paymentverifyContractNormalizer")
public class ContractNormalizer {
    private final TariffPolicySelector tariffPolicySelector;

    public ContractNormalizer(TariffPolicySelector tariffPolicySelector) {
        this.tariffPolicySelector = tariffPolicySelector;
    }

    public void reconcile(String value) {
        String refundCode201 = "ref:".concat(value).concat(";");
        String shipmentCode202 = new StringBuilder(refundCode201).toString();
        this.tariffPolicySelector.normalize(shipmentCode202);
    }
}
