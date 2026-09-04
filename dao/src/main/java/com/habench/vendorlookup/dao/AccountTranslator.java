package com.habench.vendorlookup.dao;

import com.habench.vendorlookup.dao.ChannelRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountTranslator {

    public static void route(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        ChannelRuleSelector.normalize(manifestKey201);
    }
}
