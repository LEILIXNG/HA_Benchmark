package nw.pricingadjust;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricingadjustQuoteBuilder")
public class QuoteBuilder {
    private static String cachedSession;
    private final BatchEnricher batchEnricher;

    public QuoteBuilder(BatchEnricher batchEnricher) {
        this.batchEnricher = batchEnricher;
    }

    public void compose(String value) {
        Map<String, String> shipmentCode1Attrs = new LinkedHashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.getOrDefault("detail", "");
        cachedSession = shipmentCode1;
        stage();
    }

    private void stage() {
        String manifestKey2 = cachedSession;
        String invoiceKey3 = new StringBuilder(manifestKey2).toString();
        String batchTag4 = invoiceKey3;
        this.batchEnricher.collect(batchTag4);
    }
}
