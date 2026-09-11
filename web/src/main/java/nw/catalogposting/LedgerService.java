package nw.catalogposting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("catalogpostingLedgerService")
public class LedgerService {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerService.class);
    private final ReceiptRouter receiptRouter;

    public LedgerService(ReceiptRouter receiptRouter) {
        this.receiptRouter = receiptRouter;
    }

    public void route(String value) {
        LOG.debug("接收到一次商品处理请求");
        StringBuilder receiptKey101Buffer = new StringBuilder("ref_");
        receiptKey101Buffer.append(value);
        String receiptKey101 = receiptKey101Buffer.toString();
        this.receiptRouter.prepare(receiptKey101);
    }
}
