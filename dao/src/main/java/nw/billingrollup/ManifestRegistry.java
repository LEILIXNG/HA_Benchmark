package nw.billingrollup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 账务受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ManifestRegistry {
    private static String cachedAccount;

    public static void normalize(String value) {
        final String accountRef501 = value;
        String voucherRef502 = "ref_" + accountRef501;
        cachedAccount = voucherRef502;
        route();
    }

    private static void route() {
        String paymentTag503 = cachedAccount;
        Map<String, String> refundCode504Attrs = new LinkedHashMap<String, String>();
        refundCode504Attrs.put("channel", "web");
        refundCode504Attrs.put("reference", paymentTag503);
        String refundCode504 = refundCode504Attrs.getOrDefault("reference", "");
        String shipmentCode505 = "ref_".concat(refundCode504);
        cachedAccount = shipmentCode505;
        register();
    }

    private static void register() {
        String manifestKey506 = cachedAccount;
        String invoiceKey507 = manifestKey506;
        cachedAccount = invoiceKey507;
        reconcile();
    }

    private static void reconcile() {
        String batchTag508 = cachedAccount;
        Map<String, String> orderRef509Attrs = new HashMap<String, String>();
        orderRef509Attrs.put("channel", "web");
        orderRef509Attrs.put("detail", batchTag508);
        String orderRef509 = orderRef509Attrs.get("detail");
        String quoteRef510 = String.format("ref_%s", orderRef509);
        AccountGateway.collect(quoteRef510);
    }
}
