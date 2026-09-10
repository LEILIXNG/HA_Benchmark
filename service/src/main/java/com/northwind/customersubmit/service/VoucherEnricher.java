package com.northwind.customersubmit.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("customersubmitVoucherEnricher")
public class VoucherEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherEnricher.class);
    private String pendingCatalog;

    public void resolve(String value) {
        LOG.debug("客户流程转下一环节");
        this.stage(value);
    }

    private void stage(String value) {
        List<String> receiptKey101Attrs = new ArrayList<String>();
        receiptKey101Attrs.add("web");
        receiptKey101Attrs.add(value);
        String receiptKey101 = receiptKey101Attrs.get(1);
        String accountRef102 = "ref_".concat(receiptKey101);
        this.pendingCatalog = accountRef102;
        expand();
    }

    private void expand() {
        String voucherRef103 = this.pendingCatalog;
        Map<String, String> paymentTag104Attrs = new LinkedHashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("reference", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.getOrDefault("reference", "");
        CatalogRepository.enrich(paymentTag104);
    }
}
