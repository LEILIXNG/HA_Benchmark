package com.northwind.paymentdispatch.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("paymentdispatchBundleAdapter")
public class BundleAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BundleAdapter.class);
    private final TariffPolicy tariffPolicy;

    public BundleAdapter(TariffPolicy tariffPolicy) {
        this.tariffPolicy = tariffPolicy;
    }

    public void dispatch(String value) {
        LOG.debug("支付流程转下一环节");
        String ledgerEntry401 = String.format("ref:%s;", value);
        this.tariffPolicy.refine(ledgerEntry401);
    }
}
