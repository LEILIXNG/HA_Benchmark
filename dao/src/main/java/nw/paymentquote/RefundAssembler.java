package nw.paymentquote;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class RefundAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(RefundAssembler.class);
    private String pendingOrder;
    private static String cachedOrder;

    public static void normalize(String value) {
        LOG.debug("开始整理支付字段");
        RefundAssembler self = new RefundAssembler();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> voucherRef401Attrs = new LinkedHashMap<String, String>();
        voucherRef401Attrs.put("channel", "web");
        voucherRef401Attrs.put("detail", value);
        String voucherRef401 = voucherRef401Attrs.getOrDefault("detail", "");
        String paymentTag402 = new StringBuilder(voucherRef401).toString();
        this.pendingOrder = paymentTag402;
        prepare();
    }

    private void prepare() {
        String refundCode403 = this.pendingOrder;
        String shipmentCode404 = String.valueOf(refundCode403);
        String manifestKey405 = "ref_".concat(shipmentCode404);
        cachedOrder = manifestKey405;
        refine();
    }

    private void refine() {
        String invoiceKey406 = cachedOrder;
        String batchTag407 = invoiceKey406;
        OrderGateway.attach(batchTag407);
    }
}
