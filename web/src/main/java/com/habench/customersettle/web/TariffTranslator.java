package com.habench.customersettle.web;

import com.habench.customersettle.service.TariffComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {

    public static void expand(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        TariffComposer.forward(tariffRef101);
    }
}
