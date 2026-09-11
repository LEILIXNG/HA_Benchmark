package nw.customerrollup;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 客户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("customerrollupInvoiceComposer")
public class InvoiceComposer {
    private final VoucherAdapter voucherAdapter;

    public InvoiceComposer(VoucherAdapter voucherAdapter) {
        this.voucherAdapter = voucherAdapter;
    }

    public void enrich(String value) {
        List<String> orderRef401Attrs = new ArrayList<String>();
        orderRef401Attrs.add("web");
        orderRef401Attrs.add(value);
        String orderRef401 = orderRef401Attrs.get(1);
        this.voucherAdapter.prepare(orderRef401);
    }
}
