package com.northwind.paymentreconcile.service;

import com.northwind.paymentreconcile.dao.ContractComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("paymentreconcileVoucherAdapter")
public class VoucherAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAdapter.class);
    private final ContractComposer contractComposer;

    public VoucherAdapter(ContractComposer contractComposer) {
        this.contractComposer = contractComposer;
    }

    public void submit(String value) {
        LOG.trace("进入支付处理环节");
        final String invoiceKey101 = value;
        this.contractComposer.enrich(invoiceKey101);
    }
}
