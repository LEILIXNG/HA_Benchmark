package nw.pricingquote;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingquoteReceiptAdapter")
public class ReceiptAdapter {
    private String pendingContract;
    private static String cachedContract;
    private final TariffService tariffService;

    public ReceiptAdapter(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    public void reconcile(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        String ledgerEntry201 = String.valueOf(value);
        cachedContract = ledgerEntry201;
        compose();
    }

    private void compose() {
        String channelTag202 = cachedContract;
        List<String> catalogKey203Attrs = new ArrayList<String>();
        catalogKey203Attrs.add("web");
        catalogKey203Attrs.add(channelTag202);
        String catalogKey203 = catalogKey203Attrs.get(1);
        String receiptKey204 = "ref_".concat(catalogKey203);
        this.pendingContract = receiptKey204;
        submit();
    }

    private void submit() {
        String accountRef205 = this.pendingContract;
        String voucherRef206 = "ref_".concat(accountRef205);
        this.pendingContract = voucherRef206;
        expand();
    }

    private void expand() {
        String paymentTag207 = this.pendingContract;
        String refundCode208 = String.valueOf(paymentTag207);
        this.tariffService.resolve(refundCode208);
    }
}
