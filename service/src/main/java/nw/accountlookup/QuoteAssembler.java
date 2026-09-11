package nw.accountlookup;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账户明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountlookupQuoteAssembler")
public class QuoteAssembler {
    private static String cachedVoucher;

    public void publish(String value) {
        String shipmentCode101 = value;
        cachedVoucher = shipmentCode101;
        collect();
    }

    private void collect() {
        String manifestKey102 = cachedVoucher;
        Map<String, String> invoiceKey103Attrs = new LinkedHashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("note", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.getOrDefault("note", "");
        InvoiceRegistry.dispatch(invoiceKey103);
    }
}
