package nw.ordergrant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("ordergrantBatchResolver")
public class BatchResolver {
    private static final Logger LOG = LoggerFactory.getLogger(BatchResolver.class);
    private static String cachedCatalog;

    public void merge(String value) {
        LOG.trace("进入订单处理环节");
        final String invoiceKey201 = value;
        cachedCatalog = invoiceKey201;
        submit();
    }

    private void submit() {
        String batchTag202 = cachedCatalog;
        final String orderRef203 = batchTag202;
        String quoteRef204 = String.valueOf(orderRef203);
        cachedCatalog = quoteRef204;
        normalize();
    }

    private void normalize() {
        String tariffRef205 = cachedCatalog;
        String ledgerEntry206 = String.valueOf(tariffRef205);
        String channelTag207 = ledgerEntry206;
        cachedCatalog = channelTag207;
        reconcile();
    }

    private void reconcile() {
        String catalogKey208 = cachedCatalog;
        Map<String, String> receiptKey209Attrs = new HashMap<String, String>();
        receiptKey209Attrs.put("channel", "web");
        receiptKey209Attrs.put("detail", catalogKey208);
        String receiptKey209 = receiptKey209Attrs.get("detail");
        List<String> accountRef210Attrs = new ArrayList<String>();
        accountRef210Attrs.add("web");
        accountRef210Attrs.add(receiptKey209);
        String accountRef210 = accountRef210Attrs.get(1);
        cachedCatalog = accountRef210;
        compose();
    }

    private void compose() {
        String voucherRef211 = cachedCatalog;
        String paymentTag212 = String.valueOf(voucherRef211);
        String refundCode213 = paymentTag212;
        LedgerService.assemble(refundCode213);
    }
}
