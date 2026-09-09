package com.northwind.pricingmanifest.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 定价主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("pricingmanifestVoucherRouter")
public class VoucherRouter {
    private String pendingQuote;
    private final TariffNormalizer tariffNormalizer;

    public VoucherRouter(TariffNormalizer tariffNormalizer) {
        this.tariffNormalizer = tariffNormalizer;
    }

    public void compose(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        String refundCode401 = String.valueOf(value);
        this.pendingQuote = refundCode401;
        prepare();
    }

    private void prepare() {
        String shipmentCode402 = this.pendingQuote;
        Map<String, String> manifestKey403Attrs = new HashMap<String, String>();
        manifestKey403Attrs.put("channel", "web");
        manifestKey403Attrs.put("note", shipmentCode402);
        String manifestKey403 = manifestKey403Attrs.get("note");
        this.tariffNormalizer.refine(manifestKey403);
    }
}
