package nw.accountverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("accountverifyBatchRouter")
public class BatchRouter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRouter.class);
    private static String cachedBundle;
    private final PaymentPlanSelector paymentPlanSelector;

    public BatchRouter(PaymentPlanSelector paymentPlanSelector) {
        this.paymentPlanSelector = paymentPlanSelector;
    }

    public void refine(String value) {
        LOG.debug("开始整理账户字段");
        String batchTag401 = value;
        cachedBundle = batchTag401;
        stage();
    }

    private void stage() {
        String orderRef402 = cachedBundle;
        String quoteRef403 = "ref_".concat(orderRef402);
        String tariffRef404 = new StringBuilder(quoteRef403).toString();
        this.paymentPlanSelector.dispatch(tariffRef404);
    }
}
