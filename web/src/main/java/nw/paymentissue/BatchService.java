package nw.paymentissue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymentissueBatchService")
public class BatchService {
    private static final Logger LOG = LoggerFactory.getLogger(BatchService.class);
    private static String cachedTariff;

    public void refine(String value) {
        LOG.trace("进入支付处理环节");
        String channelTag101 = String.valueOf(value);
        String catalogKey102 = channelTag101;
        cachedTariff = catalogKey102;
        resolve();
    }

    private void resolve() {
        String receiptKey103 = cachedTariff;
        final String accountRef104 = receiptKey103;
        String voucherRef105 = new StringBuilder(accountRef104).toString();
        AccountAssembler.submit(voucherRef105);
    }
}
