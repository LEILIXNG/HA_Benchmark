package com.habench.pricingreconcile.dao;

import com.habench.pricingreconcile.dao.RefundGuard;
import java.util.HashMap;
import java.util.Map;

public final class BatchAssembler {

    public static void expand(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        RefundGuard.expand(tariffRef301);
    }
}
