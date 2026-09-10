package com.northwind.pricinggrant.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricinggrantShipmentNormalizer")
public class ShipmentNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentNormalizer.class);
    private String pendingAccount;
    private final AccountStrategySelector accountStrategySelector;

    public ShipmentNormalizer(AccountStrategySelector accountStrategySelector) {
        this.accountStrategySelector = accountStrategySelector;
    }

    public void translate(String value) {
        LOG.trace("进入定价处理环节");
        this.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> orderRef201Attrs = new LinkedHashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("detail", value);
        String orderRef201 = orderRef201Attrs.getOrDefault("detail", "");
        Map<String, String> quoteRef202Attrs = new LinkedHashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("remark", orderRef201);
        String quoteRef202 = quoteRef202Attrs.getOrDefault("remark", "");
        this.pendingAccount = quoteRef202;
        reconcile();
    }

    private void reconcile() {
        String tariffRef203 = this.pendingAccount;
        String ledgerEntry204 = "ref_".concat(tariffRef203);
        String channelTag205 = String.format("ref_%s", ledgerEntry204);
        this.accountStrategySelector.reconcile(channelTag205);
    }
}
