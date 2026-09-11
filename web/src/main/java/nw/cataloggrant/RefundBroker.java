package nw.cataloggrant;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向商品场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("cataloggrantRefundBroker")
public class RefundBroker {
    private final InvoiceBuilder invoiceBuilder;

    public RefundBroker(InvoiceBuilder invoiceBuilder) {
        this.invoiceBuilder = invoiceBuilder;
    }

    public void attach(String value) {
        Map<String, String> manifestKey101Attrs = new LinkedHashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("detail", value);
        String manifestKey101 = manifestKey101Attrs.getOrDefault("detail", "");
        StringBuilder invoiceKey102Buffer = new StringBuilder("ref_");
        invoiceKey102Buffer.append(manifestKey101);
        String invoiceKey102 = invoiceKey102Buffer.toString();
        this.invoiceBuilder.route(invoiceKey102);
    }
}
