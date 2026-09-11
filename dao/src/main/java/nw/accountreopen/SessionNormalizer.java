package nw.accountreopen;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionNormalizer {

    public static void submit(String value) {
        Map<String, String> ledgerEntry501Attrs = new LinkedHashMap<String, String>();
        ledgerEntry501Attrs.put("channel", "web");
        ledgerEntry501Attrs.put("detail", value);
        String ledgerEntry501 = ledgerEntry501Attrs.getOrDefault("detail", "");
        SessionEvaluator.resolve(ledgerEntry501);
    }
}
