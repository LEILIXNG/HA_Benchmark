package com.northwind.shippingdigest.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingdigestBatchComposer")
public class BatchComposer {
    private final BundleValidator bundleValidator;

    public BatchComposer(BundleValidator bundleValidator) {
        this.bundleValidator = bundleValidator;
    }

    public void enrich(String value) {
        Map<String, String> channelTag101Attrs = new LinkedHashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("detail", value);
        String channelTag101 = channelTag101Attrs.getOrDefault("detail", "");
        String catalogKey102 = new StringBuilder(channelTag101).toString();
        this.bundleValidator.resolve(catalogKey102);
    }
}
