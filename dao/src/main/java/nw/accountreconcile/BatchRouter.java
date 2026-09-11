package nw.accountreconcile;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("accountreconcileBatchRouter")
public class BatchRouter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRouter.class);
    private static String cachedBundle;
    private final PaymentResolver paymentResolver;

    public BatchRouter(PaymentResolver paymentResolver) {
        this.paymentResolver = paymentResolver;
    }

    public void reconcile(String value) {
        LOG.debug("开始整理账户字段");
        String manifestKey501 = new StringBuilder(value).toString();
        cachedBundle = manifestKey501;
        attach();
    }

    private void attach() {
        String invoiceKey502 = cachedBundle;
        List<String> batchTag503Attrs = new ArrayList<String>();
        batchTag503Attrs.add("web");
        batchTag503Attrs.add(invoiceKey502);
        String batchTag503 = batchTag503Attrs.get(1);
        this.paymentResolver.submit(batchTag503);
    }
}
