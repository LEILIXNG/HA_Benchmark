package nw.customeradjust;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ContractAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAssembler.class);
    private String pendingTariff;
    private static String cachedTariff;

    public static void enrich(String value) {
        LOG.debug("接收到一次客户处理请求");
        ContractAssembler self = new ContractAssembler();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> invoiceKey201Attrs = new LinkedHashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("detail", value);
        String invoiceKey201 = invoiceKey201Attrs.getOrDefault("detail", "");
        Map<String, String> batchTag202Attrs = new LinkedHashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("remark", invoiceKey201);
        String batchTag202 = batchTag202Attrs.getOrDefault("remark", "");
        cachedTariff = batchTag202;
        stage();
    }

    private void stage() {
        String orderRef203 = cachedTariff;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("reference", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("reference");
        String tariffRef205 = "ref_" + quoteRef204;
        this.pendingTariff = tariffRef205;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry206 = this.pendingTariff;
        final String channelTag207 = ledgerEntry206;
        cachedTariff = channelTag207;
        register();
    }

    private void register() {
        String catalogKey208 = cachedTariff;
        String receiptKey209 = "ref_".concat(catalogKey208);
        String accountRef210 = new StringBuilder(receiptKey209).toString();
        cachedTariff = accountRef210;
        refine();
    }

    private void refine() {
        String voucherRef211 = cachedTariff;
        StringBuilder paymentTag212Buffer = new StringBuilder("ref_");
        paymentTag212Buffer.append(voucherRef211);
        String paymentTag212 = paymentTag212Buffer.toString();
        final String refundCode213 = paymentTag212;
        PaymentCollector.stage(refundCode213);
    }
}
