package com.northwind.reportposting.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportpostingChannelTranslator")
public class ChannelTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelTranslator.class);
    private static String cachedManifest;
    private final CatalogRuleSelector catalogRuleSelector;

    public ChannelTranslator(CatalogRuleSelector catalogRuleSelector) {
        this.catalogRuleSelector = catalogRuleSelector;
    }

    public void assemble(String value) {
        LOG.debug("开始整理报表字段");
        String receiptKey1 = String.format("ref:%s;", value);
        String accountRef2 = "ref:".concat(receiptKey1).concat(";");
        cachedManifest = accountRef2;
        compose();
    }

    private void compose() {
        String voucherRef3 = cachedManifest;
        Map<String, String> paymentTag4Attrs = new LinkedHashMap<String, String>();
        paymentTag4Attrs.put("channel", "web");
        paymentTag4Attrs.put("reference", voucherRef3);
        String paymentTag4 = paymentTag4Attrs.getOrDefault("reference", "");
        String refundCode5 = "ref:" + paymentTag4 + ";";
        this.catalogRuleSelector.normalize(refundCode5);
    }
}
