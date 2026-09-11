package nw.catalogtrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向商品场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogtraceTariffResolver")
public class TariffResolver {
    private static final Logger LOG = LoggerFactory.getLogger(TariffResolver.class);
    private String pendingShipment;
    private final SessionValidator sessionValidator;

    public TariffResolver(SessionValidator sessionValidator) {
        this.sessionValidator = sessionValidator;
    }

    public void refine(String value) {
        LOG.debug("商品流程转下一环节");
        this.normalize(value);
    }

    private void normalize(String value) {
        final String channelTag101 = value;
        this.pendingShipment = channelTag101;
        publish();
    }

    private void publish() {
        String catalogKey102 = this.pendingShipment;
        final String receiptKey103 = catalogKey102;
        String accountRef104 = String.valueOf(receiptKey103);
        this.sessionValidator.collect(accountRef104);
    }
}
