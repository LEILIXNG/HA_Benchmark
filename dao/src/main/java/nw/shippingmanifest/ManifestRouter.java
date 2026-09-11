package nw.shippingmanifest;

import java.util.HashMap;
import java.util.Map;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ManifestRouter {
    private static String cachedShipment;

    public static void dispatch(String value) {
        StringBuilder quoteRef301Buffer = new StringBuilder("ref_");
        quoteRef301Buffer.append(value);
        String quoteRef301 = quoteRef301Buffer.toString();
        String tariffRef302 = String.valueOf(quoteRef301);
        cachedShipment = tariffRef302;
        attach();
    }

    private static void attach() {
        String ledgerEntry303 = cachedShipment;
        String channelTag304 = String.format("ref_%s", ledgerEntry303);
        String catalogKey305 = "ref_".concat(channelTag304);
        cachedShipment = catalogKey305;
        route();
    }

    private static void route() {
        String receiptKey306 = cachedShipment;
        String accountRef307 = "ref_".concat(receiptKey306);
        Map<String, String> voucherRef308Attrs = new HashMap<String, String>();
        voucherRef308Attrs.put("channel", "web");
        voucherRef308Attrs.put("reference", accountRef307);
        String voucherRef308 = voucherRef308Attrs.get("reference");
        CatalogEnricher.submit(voucherRef308);
    }
}
