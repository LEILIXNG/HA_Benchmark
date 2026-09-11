package nw.billingrollup;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 账务主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ChannelCollector {

    public static void assemble(String value) {
        Map<String, String> manifestKey401Attrs = new LinkedHashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("detail", value);
        String manifestKey401 = manifestKey401Attrs.getOrDefault("detail", "");
        ManifestRegistry.normalize(manifestKey401);
    }
}
