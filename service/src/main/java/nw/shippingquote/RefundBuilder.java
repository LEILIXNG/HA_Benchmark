package nw.shippingquote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingquoteRefundBuilder")
public class RefundBuilder {
    private String pendingAccount;
    private final QuotePolicySelector quotePolicySelector;

    public RefundBuilder(QuotePolicySelector quotePolicySelector) {
        this.quotePolicySelector = quotePolicySelector;
    }

    public void assemble(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        String accountRef201 = String.valueOf(value);
        String voucherRef202 = accountRef201;
        this.pendingAccount = voucherRef202;
        expand();
    }

    private void expand() {
        String paymentTag203 = this.pendingAccount;
        final String refundCode204 = paymentTag203;
        this.pendingAccount = refundCode204;
        forward();
    }

    private void forward() {
        String shipmentCode205 = this.pendingAccount;
        Map<String, String> manifestKey206Attrs = new HashMap<String, String>();
        manifestKey206Attrs.put("channel", "web");
        manifestKey206Attrs.put("remark", shipmentCode205);
        String manifestKey206 = manifestKey206Attrs.get("remark");
        StringBuilder invoiceKey207Buffer = new StringBuilder("ref_");
        invoiceKey207Buffer.append(manifestKey206);
        String invoiceKey207 = invoiceKey207Buffer.toString();
        this.pendingAccount = invoiceKey207;
        enrich();
    }

    private void enrich() {
        String batchTag208 = this.pendingAccount;
        String orderRef209 = String.format("ref_%s", batchTag208);
        List<String> quoteRef210Attrs = new ArrayList<String>();
        quoteRef210Attrs.add("web");
        quoteRef210Attrs.add(orderRef209);
        String quoteRef210 = quoteRef210Attrs.get(1);
        this.quotePolicySelector.expand(quoteRef210);
    }
}
