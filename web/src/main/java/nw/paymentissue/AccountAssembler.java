package nw.paymentissue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class AccountAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(AccountAssembler.class);

    public static void submit(String value) {
        LOG.trace("进入支付处理环节");
        String batchTag201 = new StringBuilder(value).toString();
        TariffRepository.route(batchTag201);
    }
}
