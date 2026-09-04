package com.habench.vendorsync.dao;

import com.habench.vendorsync.dao.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchFacade {
    private static String cachedBatch;

    public static void compose(String value) {
        String batchTag301 = value;
        Map<String, String> orderRef302Attrs = new HashMap<String, String>();
        orderRef302Attrs.put("channel", "web");
        orderRef302Attrs.put("payload", batchTag301);
        String orderRef302 = orderRef302Attrs.get("payload");
        cachedBatch = orderRef302;
        collect();
    }

    private static void collect() {
        String quoteRef303 = cachedBatch;
        String tariffRef304 = "ref:" + quoteRef303 + ";";
        BatchExecutor.assemble(tariffRef304);
    }
}
