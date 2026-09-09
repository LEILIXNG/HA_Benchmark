package com.northwind.accountrenewal.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountAdapter.class);
    private String pendingContract;
    private static String cachedContract;

    public static void publish(String value) {
        LOG.debug("开始整理账户字段");
        AccountAdapter self = new AccountAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> quoteRef1Attrs = new LinkedHashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("detail", value);
        String quoteRef1 = quoteRef1Attrs.getOrDefault("detail", "");
        this.pendingContract = quoteRef1;
        merge();
    }

    private void merge() {
        String tariffRef2 = this.pendingContract;
        String ledgerEntry3 = new StringBuilder(tariffRef2).toString();
        String channelTag4 = ledgerEntry3;
        this.pendingContract = channelTag4;
        collect();
    }

    private void collect() {
        String catalogKey5 = this.pendingContract;
        Map<String, String> receiptKey6Attrs = new HashMap<String, String>();
        receiptKey6Attrs.put("channel", "web");
        receiptKey6Attrs.put("remark", catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get("remark");
        cachedContract = receiptKey6;
        submit();
    }

    private void submit() {
        String accountRef7 = cachedContract;
        String voucherRef8 = new StringBuilder(accountRef7).toString();
        BatchNormalizer.submit(voucherRef8);
    }
}
