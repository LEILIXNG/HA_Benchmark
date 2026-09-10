package com.northwind.billinglookup.web;

import com.northwind.billinglookup.service.ContractComposer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("billinglookupBatchBuilder")
public class BatchBuilder {
    private String pendingContract;
    private static String cachedContract;
    private final ContractComposer contractComposer;

    public BatchBuilder(ContractComposer contractComposer) {
        this.contractComposer = contractComposer;
    }

    public void refine(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        String tariffRef1 = "ref_".concat(value);
        this.pendingContract = tariffRef1;
        register();
    }

    private void register() {
        String ledgerEntry2 = this.pendingContract;
        String channelTag3 = new StringBuilder(ledgerEntry2).toString();
        cachedContract = channelTag3;
        forward();
    }

    private void forward() {
        String catalogKey4 = cachedContract;
        Map<String, String> receiptKey5Attrs = new LinkedHashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("detail", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.getOrDefault("detail", "");
        this.pendingContract = receiptKey5;
        attach();
    }

    private void attach() {
        String accountRef6 = this.pendingContract;
        StringBuilder voucherRef7Buffer = new StringBuilder("ref_");
        voucherRef7Buffer.append(accountRef6);
        String voucherRef7 = voucherRef7Buffer.toString();
        List<String> paymentTag8Attrs = new ArrayList<String>();
        paymentTag8Attrs.add("web");
        paymentTag8Attrs.add(voucherRef7);
        String paymentTag8 = paymentTag8Attrs.get(1);
        this.contractComposer.submit(paymentTag8);
    }
}
