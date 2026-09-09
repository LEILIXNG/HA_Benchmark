package com.northwind.accountverify.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("accountverifyBundleFacade")
public class BundleFacade {
    private final BatchRouter batchRouter;

    public BundleFacade(BatchRouter batchRouter) {
        this.batchRouter = batchRouter;
    }

    public void enrich(String value) {
        Map<String, String> channelTag301Attrs = new LinkedHashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("detail", value);
        String channelTag301 = channelTag301Attrs.getOrDefault("detail", "");
        String catalogKey302 = "ref:" + channelTag301 + ";";
        this.batchRouter.refine(catalogKey302);
    }
}
