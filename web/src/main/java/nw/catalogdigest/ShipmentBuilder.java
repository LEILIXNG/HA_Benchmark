package nw.catalogdigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentBuilder {
    private String pendingRefund;

    public static void collect(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.prepare(value);
    }

    private void prepare(String value) {
        String refundCode101 = String.valueOf(value);
        List<String> shipmentCode102Attrs = new ArrayList<String>();
        shipmentCode102Attrs.add("web");
        shipmentCode102Attrs.add(refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get(1);
        this.pendingRefund = shipmentCode102;
        submit();
    }

    private void submit() {
        String manifestKey103 = this.pendingRefund;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("reference", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("reference");
        AccountComposer.enrich(invoiceKey104);
    }
}
