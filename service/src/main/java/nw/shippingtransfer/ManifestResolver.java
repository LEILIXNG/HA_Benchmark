package nw.shippingtransfer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ManifestResolver {

    public static void enrich(String value) {
        Map<String, String> tariffRef301Attrs = new LinkedHashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("detail", value);
        String tariffRef301 = tariffRef301Attrs.getOrDefault("detail", "");
        String ledgerEntry302 = new StringBuilder(tariffRef301).toString();
        VoucherRouter.stage(ledgerEntry302);
    }
}
