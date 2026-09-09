package com.northwind.orderbind.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("orderbindTariffBuilder")
public class TariffBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(TariffBuilder.class);
    private final CatalogPolicySelector catalogPolicySelector;

    public TariffBuilder(CatalogPolicySelector catalogPolicySelector) {
        this.catalogPolicySelector = catalogPolicySelector;
    }

    public void assemble(String value) {
        LOG.trace("进入订单处理环节");
        String voucherRef201 = String.valueOf(value);
        this.catalogPolicySelector.dispatch(voucherRef201);
    }
}
