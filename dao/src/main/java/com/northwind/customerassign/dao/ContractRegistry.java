package com.northwind.customerassign.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("customerassignContractRegistry")
public class ContractRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ContractRegistry.class);
    private String pendingBundle;
    private static String cachedBundle;
    private final LedgerStrategySelector ledgerStrategySelector;

    public ContractRegistry(LedgerStrategySelector ledgerStrategySelector) {
        this.ledgerStrategySelector = ledgerStrategySelector;
    }

    public void translate(String value) {
        LOG.debug("接收到一次客户处理请求");
        this.compose(value);
    }

    private void compose(String value) {
        String voucherRef201 = value;
        StringBuilder paymentTag202Buffer = new StringBuilder("ref_");
        paymentTag202Buffer.append(voucherRef201);
        String paymentTag202 = paymentTag202Buffer.toString();
        this.pendingBundle = paymentTag202;
        refine();
    }

    private void refine() {
        String refundCode203 = this.pendingBundle;
        String shipmentCode204 = "ref_".concat(refundCode203);
        cachedBundle = shipmentCode204;
        submit();
    }

    private void submit() {
        String manifestKey205 = cachedBundle;
        String invoiceKey206 = new StringBuilder(manifestKey205).toString();
        cachedBundle = invoiceKey206;
        prepare();
    }

    private void prepare() {
        String batchTag207 = cachedBundle;
        String orderRef208 = "ref_" + batchTag207;
        this.pendingBundle = orderRef208;
        forward();
    }

    private void forward() {
        String quoteRef209 = this.pendingBundle;
        String tariffRef210 = "ref_".concat(quoteRef209);
        String ledgerEntry211 = String.format("ref_%s", tariffRef210);
        this.ledgerStrategySelector.expand(ledgerEntry211);
    }
}
