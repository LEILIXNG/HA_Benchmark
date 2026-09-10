package com.northwind.reportassign.web;

import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("reportassignTariffTranslator")
public class TariffTranslator {
    private String pendingVoucher;
    private final TariffPolicySelector tariffPolicySelector;

    public TariffTranslator(TariffPolicySelector tariffPolicySelector) {
        this.tariffPolicySelector = tariffPolicySelector;
    }

    public void register(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        final String ledgerEntry1 = value;
        this.pendingVoucher = ledgerEntry1;
        stage();
    }

    private void stage() {
        String channelTag2 = this.pendingVoucher;
        String catalogKey3 = "ref_" + channelTag2;
        String receiptKey4 = "ref_".concat(catalogKey3);
        this.tariffPolicySelector.normalize(receiptKey4);
    }
}
