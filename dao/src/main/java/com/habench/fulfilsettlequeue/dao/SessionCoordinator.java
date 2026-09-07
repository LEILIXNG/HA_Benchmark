package com.habench.fulfilsettlequeue.dao;

import com.habench.fulfilsettlequeue.dao.ContractPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {

    public static void resolve(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        ContractPlanSelector.translate(voucherRef301);
    }
}
