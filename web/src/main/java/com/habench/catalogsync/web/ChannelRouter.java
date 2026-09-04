package com.habench.catalogsync.web;

import com.habench.catalogsync.web.ContractPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {

    public static void stage(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        ContractPolicySelector.dispatch(tariffRef1);
    }
}
