package nw.catalogadjust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogadjustVoucherBuilder")
public class VoucherBuilder {
    private String pendingInvoice;
    private final VoucherRegistry voucherRegistry;

    public VoucherBuilder(VoucherRegistry voucherRegistry) {
        this.voucherRegistry = voucherRegistry;
    }

    public void route(String value) {
        this.register(value);
    }

    private void register(String value) {
        List<String> channelTag201Attrs = new ArrayList<String>();
        channelTag201Attrs.add("web");
        channelTag201Attrs.add(value);
        String channelTag201 = channelTag201Attrs.get(1);
        String catalogKey202 = "ref_".concat(channelTag201);
        this.pendingInvoice = catalogKey202;
        reconcile();
    }

    private void reconcile() {
        String receiptKey203 = this.pendingInvoice;
        Map<String, String> accountRef204Attrs = new HashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("reference", receiptKey203);
        String accountRef204 = accountRef204Attrs.get("reference");
        this.pendingInvoice = accountRef204;
        enrich();
    }

    private void enrich() {
        String voucherRef205 = this.pendingInvoice;
        List<String> paymentTag206Attrs = new ArrayList<String>();
        paymentTag206Attrs.add("web");
        paymentTag206Attrs.add(voucherRef205);
        String paymentTag206 = paymentTag206Attrs.get(1);
        String refundCode207 = paymentTag206;
        this.voucherRegistry.merge(refundCode207);
    }
}
