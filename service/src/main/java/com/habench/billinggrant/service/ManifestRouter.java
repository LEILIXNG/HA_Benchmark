package com.habench.billinggrant.service;

import com.habench.billinggrant.service.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {

    public static void translate(String value) {
        String accountRef301 = "ref:" + value + ";";
        Map<String, String> voucherRef302Attrs = new HashMap<String, String>();
        voucherRef302Attrs.put("channel", "web");
        voucherRef302Attrs.put("payload", accountRef301);
        String voucherRef302 = voucherRef302Attrs.get("payload");
        ChannelRepository.collect(voucherRef302);
    }
}
