package nw.customerexport;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 客户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelResolver {
    private static String cachedManifest;

    public static void translate(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("detail", value);
        String orderRef101 = orderRef101Attrs.get("detail");
        cachedManifest = orderRef101;
        register();
    }

    private static void register() {
        String quoteRef102 = cachedManifest;
        Map<String, String> tariffRef103Attrs = new LinkedHashMap<String, String>();
        tariffRef103Attrs.put("channel", "web");
        tariffRef103Attrs.put("note", quoteRef102);
        String tariffRef103 = tariffRef103Attrs.getOrDefault("note", "");
        cachedManifest = tariffRef103;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry104 = cachedManifest;
        String channelTag105 = String.valueOf(ledgerEntry104);
        ManifestExecutor.reconcile(channelTag105);
    }
}
