package com.northwind.accountbind.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountbindLedgerNormalizer")
public class LedgerNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerNormalizer.class);
    private String pendingReceipt;
    private final ReceiptRepository receiptRepository;

    public LedgerNormalizer(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public void register(String value) {
        LOG.trace("进入账户处理环节");
        this.attach(value);
    }

    private void attach(String value) {
        String manifestKey101 = "ref:" + value + ";";
        this.pendingReceipt = manifestKey101;
        prepare();
    }

    private void prepare() {
        String invoiceKey102 = this.pendingReceipt;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("note", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("note");
        this.receiptRepository.attach(batchTag103);
    }
}
