package com.northwind.paymentposting.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogAdapter.class);

    public static void reconcile(String value) {
        LOG.debug("支付流程转下一环节");
        Map<String, String> tariffRef501Attrs = new HashMap<String, String>();
        tariffRef501Attrs.put("channel", "web");
        tariffRef501Attrs.put("detail", value);
        String tariffRef501 = tariffRef501Attrs.get("detail");
        final String ledgerEntry502 = tariffRef501;
        ContractRuleSelector.forward(ledgerEntry502);
    }
}
