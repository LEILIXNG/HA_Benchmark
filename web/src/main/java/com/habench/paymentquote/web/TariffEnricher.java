package com.habench.paymentquote.web;

import com.habench.paymentquote.web.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {

    public static void submit(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        String voucherRef202 = accountRef201;
        ChannelRepository.resolve(voucherRef202);
    }
}
