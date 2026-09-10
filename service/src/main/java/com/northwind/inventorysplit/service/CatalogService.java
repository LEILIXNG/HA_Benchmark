package com.northwind.inventorysplit.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("inventorysplitCatalogService")
public class CatalogService {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogService.class);
    private String pendingManifest;
    private final PaymentComposer paymentComposer;

    public CatalogService(PaymentComposer paymentComposer) {
        this.paymentComposer = paymentComposer;
    }

    public void prepare(String value) {
        LOG.debug("库存流程转下一环节");
        this.publish(value);
    }

    private void publish(String value) {
        String receiptKey101 = String.format("ref_%s", value);
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("remark", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("remark");
        this.pendingManifest = accountRef102;
        forward();
    }

    private void forward() {
        String voucherRef103 = this.pendingManifest;
        final String paymentTag104 = voucherRef103;
        String refundCode105 = "ref_" + paymentTag104;
        this.paymentComposer.prepare(refundCode105);
    }
}
