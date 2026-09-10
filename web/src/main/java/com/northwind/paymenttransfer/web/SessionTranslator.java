package com.northwind.paymenttransfer.web;

import com.northwind.paymenttransfer.service.ManifestResolver;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymenttransferSessionTranslator")
public class SessionTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(SessionTranslator.class);
    private String pendingInvoice;

    public void publish(String value) {
        LOG.debug("支付流程转下一环节");
        this.stage(value);
    }

    private void stage(String value) {
        String batchTag101 = "ref_" + value;
        this.pendingInvoice = batchTag101;
        refine();
    }

    private void refine() {
        String orderRef102 = this.pendingInvoice;
        Map<String, String> quoteRef103Attrs = new HashMap<String, String>();
        quoteRef103Attrs.put("channel", "web");
        quoteRef103Attrs.put("note", orderRef102);
        String quoteRef103 = quoteRef103Attrs.get("note");
        String tariffRef104 = "ref_".concat(quoteRef103);
        ManifestResolver.reconcile(tariffRef104);
    }
}
