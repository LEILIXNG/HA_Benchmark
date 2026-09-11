package nw.paymenthold;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 支付主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("paymentholdReceiptAdapter")
public class ReceiptAdapter {
    private String pendingPayment;
    private static String cachedPayment;
    private final ShipmentRouter shipmentRouter;

    public ReceiptAdapter(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    public void expand(String value) {
        this.assemble(value);
    }

    private void assemble(String value) {
        final String paymentTag201 = value;
        this.pendingPayment = paymentTag201;
        register();
    }

    private void register() {
        String refundCode202 = this.pendingPayment;
        final String shipmentCode203 = refundCode202;
        cachedPayment = shipmentCode203;
        normalize();
    }

    private void normalize() {
        String manifestKey204 = cachedPayment;
        String invoiceKey205 = "ref_".concat(manifestKey204);
        this.pendingPayment = invoiceKey205;
        compose();
    }

    private void compose() {
        String batchTag206 = this.pendingPayment;
        Map<String, String> orderRef207Attrs = new HashMap<String, String>();
        orderRef207Attrs.put("channel", "web");
        orderRef207Attrs.put("note", batchTag206);
        String orderRef207 = orderRef207Attrs.get("note");
        cachedPayment = orderRef207;
        translate();
    }

    private void translate() {
        String quoteRef208 = cachedPayment;
        Map<String, String> tariffRef209Attrs = new HashMap<String, String>();
        tariffRef209Attrs.put("channel", "web");
        tariffRef209Attrs.put("detail", quoteRef208);
        String tariffRef209 = tariffRef209Attrs.get("detail");
        this.pendingPayment = tariffRef209;
        resolve();
    }

    private void resolve() {
        String ledgerEntry210 = this.pendingPayment;
        String channelTag211 = "ref_".concat(ledgerEntry210);
        String catalogKey212 = String.format("ref_%s", channelTag211);
        this.shipmentRouter.compose(catalogKey212);
    }
}
