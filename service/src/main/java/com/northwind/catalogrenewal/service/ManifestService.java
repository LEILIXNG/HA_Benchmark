package com.northwind.catalogrenewal.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("catalogrenewalManifestService")
public class ManifestService {
    private static String cachedContract;
    private final BundleCoordinator bundleCoordinator;

    public ManifestService(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    public void assemble(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("detail", value);
        String orderRef301 = orderRef301Attrs.get("detail");
        String quoteRef302 = new StringBuilder(orderRef301).toString();
        cachedContract = quoteRef302;
        refine();
    }

    private void refine() {
        String tariffRef303 = cachedContract;
        String ledgerEntry304 = "ref:" + tariffRef303 + ";";
        String channelTag305 = ledgerEntry304;
        this.bundleCoordinator.dispatch(channelTag305);
    }
}
