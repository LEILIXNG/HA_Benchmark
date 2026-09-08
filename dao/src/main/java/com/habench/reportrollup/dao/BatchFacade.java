package com.habench.reportrollup.dao;

import com.habench.reportrollup.dao.VoucherFetcher;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {

    public static void register(String value) {
        String quoteRef301 = "ref:" + value + ";";
        Map<String, String> tariffRef302Attrs = new HashMap<String, String>();
        tariffRef302Attrs.put("channel", "web");
        tariffRef302Attrs.put("payload", quoteRef301);
        String tariffRef302 = tariffRef302Attrs.get("payload");
        VoucherFetcher.enrich(tariffRef302);
    }
}
