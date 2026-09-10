package com.northwind.inventorysplit.service;

import com.northwind.inventorysplit.dao.LedgerTranslator;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("inventorysplitPaymentComposer")
public class PaymentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentComposer.class);
    private String pendingManifest;
    private static String cachedManifest;
    private final LedgerTranslator ledgerTranslator;

    public PaymentComposer(LedgerTranslator ledgerTranslator) {
        this.ledgerTranslator = ledgerTranslator;
    }

    public void prepare(String value) {
        LOG.debug("库存流程转下一环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        String quoteRef201 = new StringBuilder(value).toString();
        StringBuilder tariffRef202Buffer = new StringBuilder("ref_");
        tariffRef202Buffer.append(quoteRef201);
        String tariffRef202 = tariffRef202Buffer.toString();
        this.pendingManifest = tariffRef202;
        assemble();
    }

    private void assemble() {
        String ledgerEntry203 = this.pendingManifest;
        String channelTag204 = "ref_".concat(ledgerEntry203);
        cachedManifest = channelTag204;
        forward();
    }

    private void forward() {
        String catalogKey205 = cachedManifest;
        String receiptKey206 = catalogKey205;
        List<String> accountRef207Attrs = new ArrayList<String>();
        accountRef207Attrs.add("web");
        accountRef207Attrs.add(receiptKey206);
        String accountRef207 = accountRef207Attrs.get(1);
        cachedManifest = accountRef207;
        collect();
    }

    private void collect() {
        String voucherRef208 = cachedManifest;
        List<String> paymentTag209Attrs = new ArrayList<String>();
        paymentTag209Attrs.add("web");
        paymentTag209Attrs.add(voucherRef208);
        String paymentTag209 = paymentTag209Attrs.get(1);
        cachedManifest = paymentTag209;
        stage();
    }

    private void stage() {
        String refundCode210 = cachedManifest;
        String shipmentCode211 = String.format("ref_%s", refundCode210);
        List<String> manifestKey212Attrs = new ArrayList<String>();
        manifestKey212Attrs.add("web");
        manifestKey212Attrs.add(shipmentCode211);
        String manifestKey212 = manifestKey212Attrs.get(1);
        this.ledgerTranslator.prepare(manifestKey212);
    }
}
