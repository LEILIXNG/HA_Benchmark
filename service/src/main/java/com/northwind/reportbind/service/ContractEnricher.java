package com.northwind.reportbind.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("reportbindContractEnricher")
public class ContractEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEnricher.class);
    private String pendingContract;
    private final LedgerPolicy ledgerPolicy;

    public ContractEnricher(LedgerPolicy ledgerPolicy) {
        this.ledgerPolicy = ledgerPolicy;
    }

    public void enrich(String value) {
        LOG.debug("报表流程转下一环节");
        this.assemble(value);
    }

    private void assemble(String value) {
        String tariffRef201 = "ref_" + value;
        this.pendingContract = tariffRef201;
        merge();
    }

    private void merge() {
        String ledgerEntry202 = this.pendingContract;
        String channelTag203 = "ref_" + ledgerEntry202;
        this.pendingContract = channelTag203;
        prepare();
    }

    private void prepare() {
        String catalogKey204 = this.pendingContract;
        Map<String, String> receiptKey205Attrs = new LinkedHashMap<String, String>();
        receiptKey205Attrs.put("channel", "web");
        receiptKey205Attrs.put("detail", catalogKey204);
        String receiptKey205 = receiptKey205Attrs.getOrDefault("detail", "");
        String accountRef206 = "ref_".concat(receiptKey205);
        this.ledgerPolicy.reconcile(accountRef206);
    }
}
