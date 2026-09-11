package nw.inventorytrace;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventorytraceBatchCoordinator")
public class BatchCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchCoordinator.class);
    private static String cachedOrder;

    public void attach(String value) {
        LOG.debug("接收到一次库存处理请求");
        String catalogKey1 = String.valueOf(value);
        cachedOrder = catalogKey1;
        reconcile();
    }

    private void reconcile() {
        String receiptKey2 = cachedOrder;
        Map<String, String> accountRef3Attrs = new HashMap<String, String>();
        accountRef3Attrs.put("channel", "web");
        accountRef3Attrs.put("note", receiptKey2);
        String accountRef3 = accountRef3Attrs.get("note");
        cachedOrder = accountRef3;
        dispatch();
    }

    private void dispatch() {
        String voucherRef4 = cachedOrder;
        StringBuilder paymentTag5Buffer = new StringBuilder("ref_");
        paymentTag5Buffer.append(voucherRef4);
        String paymentTag5 = paymentTag5Buffer.toString();
        Map<String, String> refundCode6Attrs = new HashMap<String, String>();
        refundCode6Attrs.put("channel", "web");
        refundCode6Attrs.put("remark", paymentTag5);
        String refundCode6 = refundCode6Attrs.get("remark");
        cachedOrder = refundCode6;
        register();
    }

    private void register() {
        String shipmentCode7 = cachedOrder;
        String manifestKey8 = "ref_".concat(shipmentCode7);
        ChannelTranslator.forward(manifestKey8);
    }
}
