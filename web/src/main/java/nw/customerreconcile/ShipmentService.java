package nw.customerreconcile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("customerreconcileShipmentService")
public class ShipmentService {
    private String pendingShipment;
    private static String cachedShipment;
    private final ManifestRouter manifestRouter;

    public ShipmentService(ManifestRouter manifestRouter) {
        this.manifestRouter = manifestRouter;
    }

    public void publish(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        String paymentTag1 = "ref_" + value;
        List<String> refundCode2Attrs = new ArrayList<String>();
        refundCode2Attrs.add("web");
        refundCode2Attrs.add(paymentTag1);
        String refundCode2 = refundCode2Attrs.get(1);
        this.pendingShipment = refundCode2;
        normalize();
    }

    private void normalize() {
        String shipmentCode3 = this.pendingShipment;
        Map<String, String> manifestKey4Attrs = new LinkedHashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("reference", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.getOrDefault("reference", "");
        this.pendingShipment = manifestKey4;
        assemble();
    }

    private void assemble() {
        String invoiceKey5 = this.pendingShipment;
        String batchTag6 = "ref_".concat(invoiceKey5);
        this.pendingShipment = batchTag6;
        stage();
    }

    private void stage() {
        String orderRef7 = this.pendingShipment;
        String quoteRef8 = new StringBuilder(orderRef7).toString();
        final String tariffRef9 = quoteRef8;
        cachedShipment = tariffRef9;
        submit();
    }

    private void submit() {
        String ledgerEntry10 = cachedShipment;
        final String channelTag11 = ledgerEntry10;
        String catalogKey12 = "ref_" + channelTag11;
        this.pendingShipment = catalogKey12;
        translate();
    }

    private void translate() {
        String receiptKey13 = this.pendingShipment;
        List<String> accountRef14Attrs = new ArrayList<String>();
        accountRef14Attrs.add("web");
        accountRef14Attrs.add(receiptKey13);
        String accountRef14 = accountRef14Attrs.get(1);
        this.pendingShipment = accountRef14;
        compose();
    }

    private void compose() {
        String voucherRef15 = this.pendingShipment;
        String paymentTag16 = String.valueOf(voucherRef15);
        this.manifestRouter.compose(paymentTag16);
    }
}
