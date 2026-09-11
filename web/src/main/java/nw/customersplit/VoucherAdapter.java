package nw.customersplit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customersplitVoucherAdapter")
public class VoucherAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAdapter.class);
    private String pendingOrder;
    private static String cachedOrder;

    public void forward(String value) {
        LOG.trace("进入客户处理环节");
        this.compose(value);
    }

    private void compose(String value) {
        Map<String, String> voucherRef1Attrs = new LinkedHashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("detail", value);
        String voucherRef1 = voucherRef1Attrs.getOrDefault("detail", "");
        String paymentTag2 = String.valueOf(voucherRef1);
        cachedOrder = paymentTag2;
        normalize();
    }

    private void normalize() {
        String refundCode3 = cachedOrder;
        String shipmentCode4 = "ref_".concat(refundCode3);
        cachedOrder = shipmentCode4;
        assemble();
    }

    private void assemble() {
        String manifestKey5 = cachedOrder;
        List<String> invoiceKey6Attrs = new ArrayList<String>();
        invoiceKey6Attrs.add("web");
        invoiceKey6Attrs.add(manifestKey5);
        String invoiceKey6 = invoiceKey6Attrs.get(1);
        final String batchTag7 = invoiceKey6;
        this.pendingOrder = batchTag7;
        prepare();
    }

    private void prepare() {
        String orderRef8 = this.pendingOrder;
        StringBuilder quoteRef9Buffer = new StringBuilder("ref_");
        quoteRef9Buffer.append(orderRef8);
        String quoteRef9 = quoteRef9Buffer.toString();
        final String tariffRef10 = quoteRef9;
        TariffValidator.stage(tariffRef10);
    }
}
