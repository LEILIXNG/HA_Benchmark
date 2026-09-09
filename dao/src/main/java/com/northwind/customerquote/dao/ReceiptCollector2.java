package com.northwind.customerquote.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("customerquoteReceiptCollector2")
public class ReceiptCollector2 {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptCollector2.class);
    private String pendingAccount;
    private final BundlePolicySelector bundlePolicySelector;

    public ReceiptCollector2(BundlePolicySelector bundlePolicySelector) {
        this.bundlePolicySelector = bundlePolicySelector;
    }

    public void dispatch(String value) {
        LOG.trace("进入客户处理环节");
        this.forward(value);
    }

    private void forward(String value) {
        String quoteRef201 = String.format("ref:%s;", value);
        this.pendingAccount = quoteRef201;
        normalize();
    }

    private void normalize() {
        String tariffRef202 = this.pendingAccount;
        Map<String, String> ledgerEntry203Attrs = new LinkedHashMap<String, String>();
        ledgerEntry203Attrs.put("channel", "web");
        ledgerEntry203Attrs.put("note", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.getOrDefault("note", "");
        this.bundlePolicySelector.submit(ledgerEntry203);
    }
}
