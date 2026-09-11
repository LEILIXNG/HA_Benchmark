package nw.paymentapprove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(TariffCoordinator.class);
    private static String cachedAccount;

    public static void collect(String value) {
        LOG.debug("开始整理支付字段");
        String channelTag201 = value;
        String catalogKey202 = String.valueOf(channelTag201);
        cachedAccount = catalogKey202;
        dispatch();
    }

    private static void dispatch() {
        String receiptKey203 = cachedAccount;
        String accountRef204 = new StringBuilder(receiptKey203).toString();
        AccountFetcher.merge(accountRef204);
    }
}
