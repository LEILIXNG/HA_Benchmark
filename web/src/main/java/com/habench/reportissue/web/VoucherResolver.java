package com.habench.reportissue.web;

import com.habench.reportissue.service.AccountService;
import java.util.HashMap;
import java.util.Map;

public final class VoucherResolver {

    public static void stage(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        String voucherRef202 = "ref:" + accountRef201 + ";";
        AccountService.submit(voucherRef202);
    }
}
