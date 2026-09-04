package com.habench.catalogverify.dao;

import com.habench.catalogverify.dao.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleService {

    public static void submit(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        String quoteRef202 = orderRef201;
        ChannelRepository.compose(quoteRef202);
    }
}
