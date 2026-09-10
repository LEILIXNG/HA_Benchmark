package com.northwind.billingmanifest.service;

import com.northwind.billingmanifest.dao.ReceiptEnricher;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("billingmanifestLedgerTranslator")
public class LedgerTranslator {
    private final ReceiptEnricher receiptEnricher;

    public LedgerTranslator(ReceiptEnricher receiptEnricher) {
        this.receiptEnricher = receiptEnricher;
    }

    public void expand(String value) {
        List<String> invoiceKey101Attrs = new ArrayList<String>();
        invoiceKey101Attrs.add("web");
        invoiceKey101Attrs.add(value);
        String invoiceKey101 = invoiceKey101Attrs.get(1);
        StringBuilder batchTag102Buffer = new StringBuilder("ref_");
        batchTag102Buffer.append(invoiceKey101);
        String batchTag102 = batchTag102Buffer.toString();
        this.receiptEnricher.resolve(batchTag102);
    }
}
