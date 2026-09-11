package nw.accountreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("accountreconcileRefundEnricher")
public class RefundEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(RefundEnricher.class);
    private final BatchRouter batchRouter;

    public RefundEnricher(BatchRouter batchRouter) {
        this.batchRouter = batchRouter;
    }

    public void attach(String value) {
        LOG.debug("开始整理账户字段");
        String tariffRef401 = value;
        this.batchRouter.reconcile(tariffRef401);
    }
}
