package com.habench.billinglookup.dao;

import com.habench.billinglookup.dao.QuoteService;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {
    private static String cachedAccount;

    public static void submit(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = catalogKey201;
        cachedAccount = receiptKey202;
        attach();
    }

    private static void attach() {
        String accountRef203 = cachedAccount;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        QuoteService.dispatch(voucherRef204);
    }
}
