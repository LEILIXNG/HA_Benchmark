package nw.customerrenewal;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("customerrenewalContractComposer")
public class ContractComposer {
    private String pendingQuote;
    private final QuoteLoader quoteLoader;

    public ContractComposer(QuoteLoader quoteLoader) {
        this.quoteLoader = quoteLoader;
    }

    public void dispatch(String value) {
        this.translate(value);
    }

    private void translate(String value) {
        String shipmentCode101 = "ref_".concat(value);
        Map<String, String> manifestKey102Attrs = new LinkedHashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("remark", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.getOrDefault("remark", "");
        this.pendingQuote = manifestKey102;
        merge();
    }

    private void merge() {
        String invoiceKey103 = this.pendingQuote;
        String batchTag104 = new StringBuilder(invoiceKey103).toString();
        this.quoteLoader.route(batchTag104);
    }
}
