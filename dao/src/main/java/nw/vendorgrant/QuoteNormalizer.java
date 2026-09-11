package nw.vendorgrant;

import java.util.HashMap;
import java.util.Map;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteNormalizer {
    private static String cachedOrder;

    public static void route(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.get("detail");
        String receiptKey202 = new StringBuilder(catalogKey201).toString();
        cachedOrder = receiptKey202;
        prepare();
    }

    private static void prepare() {
        String accountRef203 = cachedOrder;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("reference", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("reference");
        String paymentTag205 = voucherRef204;
        cachedOrder = paymentTag205;
        resolve();
    }

    private static void resolve() {
        String refundCode206 = cachedOrder;
        String shipmentCode207 = refundCode206;
        cachedOrder = shipmentCode207;
        translate();
    }

    private static void translate() {
        String manifestKey208 = cachedOrder;
        String invoiceKey209 = String.format("ref_%s", manifestKey208);
        OrderExecutor.forward(invoiceKey209);
    }
}
