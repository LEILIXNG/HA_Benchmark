package nw.inventoryrefund;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryrefundTariffRegistry")
public class TariffRegistry {
    private static String cachedInvoice;
    private final VoucherNormalizer voucherNormalizer;

    public TariffRegistry(VoucherNormalizer voucherNormalizer) {
        this.voucherNormalizer = voucherNormalizer;
    }

    public void reconcile(String value) {
        List<String> batchTag1Attrs = new ArrayList<String>();
        batchTag1Attrs.add("web");
        batchTag1Attrs.add(value);
        String batchTag1 = batchTag1Attrs.get(1);
        cachedInvoice = batchTag1;
        forward();
    }

    private void forward() {
        String orderRef2 = cachedInvoice;
        Map<String, String> quoteRef3Attrs = new HashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("note", orderRef2);
        String quoteRef3 = quoteRef3Attrs.get("note");
        String tariffRef4 = "ref_" + quoteRef3;
        this.voucherNormalizer.publish(tariffRef4);
    }
}
