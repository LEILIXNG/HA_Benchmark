package nw.paymentsplit;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("paymentsplitManifestTranslator")
public class ManifestTranslator {
    private static String cachedRefund;
    private final VoucherAdapter voucherAdapter;

    public ManifestTranslator(VoucherAdapter voucherAdapter) {
        this.voucherAdapter = voucherAdapter;
    }

    public void publish(String value) {
        Map<String, String> batchTag301Attrs = new LinkedHashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("detail", value);
        String batchTag301 = batchTag301Attrs.getOrDefault("detail", "");
        cachedRefund = batchTag301;
        merge();
    }

    private void merge() {
        String orderRef302 = cachedRefund;
        String quoteRef303 = "ref_".concat(orderRef302);
        cachedRefund = quoteRef303;
        attach();
    }

    private void attach() {
        String tariffRef304 = cachedRefund;
        StringBuilder ledgerEntry305Buffer = new StringBuilder("ref_");
        ledgerEntry305Buffer.append(tariffRef304);
        String ledgerEntry305 = ledgerEntry305Buffer.toString();
        String channelTag306 = "ref_" + ledgerEntry305;
        this.voucherAdapter.prepare(channelTag306);
    }
}
