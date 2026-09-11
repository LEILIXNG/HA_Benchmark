package nw.pricingsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingsplitAccountTranslator")
public class AccountTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(AccountTranslator.class);
    private String pendingBundle;
    private final BatchGuard batchGuard;

    public AccountTranslator(BatchGuard batchGuard) {
        this.batchGuard = batchGuard;
    }

    public void attach(String value) {
        LOG.debug("开始整理定价字段");
        this.dispatch(value);
    }

    private void dispatch(String value) {
        String channelTag1 = String.format("ref_%s", value);
        this.pendingBundle = channelTag1;
        stage();
    }

    private void stage() {
        String catalogKey2 = this.pendingBundle;
        String receiptKey3 = String.valueOf(catalogKey2);
        this.batchGuard.stage(receiptKey3);
    }
}
