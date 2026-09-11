package nw.billingarchive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingarchiveSessionGuard")
public class SessionGuard {
    private static final Logger LOG = LoggerFactory.getLogger(SessionGuard.class);
    private final AccountFacade accountFacade;

    public SessionGuard(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    public void enrich(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.accountFacade.collect(value);
    }
}
