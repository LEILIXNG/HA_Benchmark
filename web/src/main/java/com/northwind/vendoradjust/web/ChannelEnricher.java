package com.northwind.vendoradjust.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendoradjustChannelEnricher")
public class ChannelEnricher {
    private final ManifestEnricher manifestEnricher;

    public ChannelEnricher(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    public void prepare(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("detail", value);
        String batchTag101 = batchTag101Attrs.get("detail");
        this.manifestEnricher.assemble(batchTag101);
    }
}
