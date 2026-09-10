package com.northwind.vendormerge.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendormergeManifestEnricher")
public class ManifestEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestEnricher.class);
    private String pendingCatalog;
    private static String cachedCatalog;
    private final PaymentBroker paymentBroker;

    public ManifestEnricher(PaymentBroker paymentBroker) {
        this.paymentBroker = paymentBroker;
    }

    public void reconcile(String value) {
        LOG.trace("进入供应商处理环节");
        this.enrich(value);
    }

    private void enrich(String value) {
        String channelTag101 = "ref_" + value;
        StringBuilder catalogKey102Buffer = new StringBuilder("ref_");
        catalogKey102Buffer.append(channelTag101);
        String catalogKey102 = catalogKey102Buffer.toString();
        this.pendingCatalog = catalogKey102;
        submit();
    }

    private void submit() {
        String receiptKey103 = this.pendingCatalog;
        List<String> accountRef104Attrs = new ArrayList<String>();
        accountRef104Attrs.add("web");
        accountRef104Attrs.add(receiptKey103);
        String accountRef104 = accountRef104Attrs.get(1);
        cachedCatalog = accountRef104;
        register();
    }

    private void register() {
        String voucherRef105 = cachedCatalog;
        List<String> paymentTag106Attrs = new ArrayList<String>();
        paymentTag106Attrs.add("web");
        paymentTag106Attrs.add(voucherRef105);
        String paymentTag106 = paymentTag106Attrs.get(1);
        String refundCode107 = String.valueOf(paymentTag106);
        this.paymentBroker.normalize(refundCode107);
    }
}
