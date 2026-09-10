package com.northwind.orderissue.service;

import com.northwind.orderissue.dao.LedgerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("orderissueInvoiceService")
public class InvoiceService {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceService.class);
    private String pendingLedger;
    private final LedgerAdapter ledgerAdapter;

    public InvoiceService(LedgerAdapter ledgerAdapter) {
        this.ledgerAdapter = ledgerAdapter;
    }

    public void refine(String value) {
        LOG.debug("订单流程转下一环节");
        this.compose(value);
    }

    private void compose(String value) {
        final String channelTag101 = value;
        StringBuilder catalogKey102Buffer = new StringBuilder("ref_");
        catalogKey102Buffer.append(channelTag101);
        String catalogKey102 = catalogKey102Buffer.toString();
        this.pendingLedger = catalogKey102;
        route();
    }

    private void route() {
        String receiptKey103 = this.pendingLedger;
        String accountRef104 = String.valueOf(receiptKey103);
        String voucherRef105 = accountRef104;
        this.ledgerAdapter.forward(voucherRef105);
    }
}
