package nw.paymentreconcile;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("paymentreconcileContractComposer")
public class ContractComposer {
    private String pendingManifest;
    private static String cachedManifest;

    public void enrich(String value) {
        this.translate(value);
    }

    private void translate(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("detail", value);
        String voucherRef201 = voucherRef201Attrs.get("detail");
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("remark", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("remark");
        cachedManifest = paymentTag202;
        refine();
    }

    private void refine() {
        String refundCode203 = cachedManifest;
        StringBuilder shipmentCode204Buffer = new StringBuilder("ref_");
        shipmentCode204Buffer.append(refundCode203);
        String shipmentCode204 = shipmentCode204Buffer.toString();
        String manifestKey205 = "ref_" + shipmentCode204;
        cachedManifest = manifestKey205;
        attach();
    }

    private void attach() {
        String invoiceKey206 = cachedManifest;
        String batchTag207 = "ref_" + invoiceKey206;
        String orderRef208 = batchTag207;
        this.pendingManifest = orderRef208;
        expand();
    }

    private void expand() {
        String quoteRef209 = this.pendingManifest;
        Map<String, String> tariffRef210Attrs = new HashMap<String, String>();
        tariffRef210Attrs.put("channel", "web");
        tariffRef210Attrs.put("remark", quoteRef209);
        String tariffRef210 = tariffRef210Attrs.get("remark");
        Map<String, String> ledgerEntry211Attrs = new LinkedHashMap<String, String>();
        ledgerEntry211Attrs.put("channel", "web");
        ledgerEntry211Attrs.put("note", tariffRef210);
        String ledgerEntry211 = ledgerEntry211Attrs.getOrDefault("note", "");
        cachedManifest = ledgerEntry211;
        merge();
    }

    private void merge() {
        String channelTag212 = cachedManifest;
        String catalogKey213 = "ref_" + channelTag212;
        String receiptKey214 = String.valueOf(catalogKey213);
        OrderBroker.normalize(receiptKey214);
    }
}
