package nw.billingsettlequeue;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向账务场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingsettlequeuePaymentTranslator")
public class PaymentTranslator {
    private final InvoiceAssembler invoiceAssembler;

    public PaymentTranslator(InvoiceAssembler invoiceAssembler) {
        this.invoiceAssembler = invoiceAssembler;
    }

    public void merge(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("detail", value);
        String shipmentCode101 = shipmentCode101Attrs.get("detail");
        this.invoiceAssembler.publish(shipmentCode101);
    }
}
