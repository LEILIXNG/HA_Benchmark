package com.habench.catalogrevise.web;

import com.habench.catalogrevise.web.InvoiceRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelService {

    public static void normalize(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        InvoiceRepository.compose(channelTag101);
    }
}
