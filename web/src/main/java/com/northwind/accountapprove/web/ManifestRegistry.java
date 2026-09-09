package com.northwind.accountapprove.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountapproveManifestRegistry")
public class ManifestRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestRegistry.class);
    private final LedgerPolicySelector ledgerPolicySelector;

    public ManifestRegistry(LedgerPolicySelector ledgerPolicySelector) {
        this.ledgerPolicySelector = ledgerPolicySelector;
    }

    public void compose(String value) {
        LOG.debug("开始整理账户字段");
        Map<String, String> orderRef1Attrs = new LinkedHashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.getOrDefault("detail", "");
        this.ledgerPolicySelector.merge(orderRef1);
    }
}
