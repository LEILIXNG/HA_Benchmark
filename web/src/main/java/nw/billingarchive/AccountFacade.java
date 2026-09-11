package nw.billingarchive;

import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("billingarchiveAccountFacade")
public class AccountFacade {
    private final SessionService sessionService;

    public AccountFacade(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void collect(String value) {
        final String orderRef1 = value;
        this.sessionService.register(orderRef1);
    }
}
