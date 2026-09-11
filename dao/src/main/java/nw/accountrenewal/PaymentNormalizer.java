package nw.accountrenewal;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 账户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class PaymentNormalizer {

    public static void attach(String value) {
        Map<String, String> shipmentCode401Attrs = new LinkedHashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("detail", value);
        String shipmentCode401 = shipmentCode401Attrs.getOrDefault("detail", "");
        ContractEvaluator.compose(shipmentCode401);
    }
}
