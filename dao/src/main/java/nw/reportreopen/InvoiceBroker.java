package nw.reportreopen;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("reportreopenInvoiceBroker")
public class InvoiceBroker {
    private final BatchExecutor batchExecutor;

    public InvoiceBroker(BatchExecutor batchExecutor) {
        this.batchExecutor = batchExecutor;
    }

    public void normalize(String value) {
        Map<String, String> voucherRef401Attrs = new HashMap<String, String>();
        voucherRef401Attrs.put("channel", "web");
        voucherRef401Attrs.put("detail", value);
        String voucherRef401 = voucherRef401Attrs.get("detail");
        String paymentTag402 = String.valueOf(voucherRef401);
        this.batchExecutor.normalize(paymentTag402);
    }
}
