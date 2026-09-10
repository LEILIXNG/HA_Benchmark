package com.northwind.paymentrollup.web;

import com.northwind.paymentrollup.service.BundleCoordinator2;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("paymentrollupInvoiceNormalizer")
public class InvoiceNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceNormalizer.class);
    private String pendingInvoice;
    private final BundleCoordinator2 bundleCoordinator2;

    public InvoiceNormalizer(BundleCoordinator2 bundleCoordinator2) {
        this.bundleCoordinator2 = bundleCoordinator2;
    }

    public void assemble(String value) {
        LOG.debug("开始整理支付字段");
        this.submit(value);
    }

    private void submit(String value) {
        String catalogKey201 = String.format("ref_%s", value);
        List<String> receiptKey202Attrs = new ArrayList<String>();
        receiptKey202Attrs.add("web");
        receiptKey202Attrs.add(catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get(1);
        this.pendingInvoice = receiptKey202;
        compose();
    }

    private void compose() {
        String accountRef203 = this.pendingInvoice;
        List<String> voucherRef204Attrs = new ArrayList<String>();
        voucherRef204Attrs.add("web");
        voucherRef204Attrs.add(accountRef203);
        String voucherRef204 = voucherRef204Attrs.get(1);
        this.bundleCoordinator2.enrich(voucherRef204);
    }
}
