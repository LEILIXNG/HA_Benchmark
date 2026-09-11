package nw.accountclose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("accountcloseInvoiceRouter")
public class InvoiceRouter {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceRouter.class);
    private final AccountBuilder accountBuilder;

    public InvoiceRouter(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    public void refine(String value) {
        LOG.debug("接收到一次账户处理请求");
        String accountRef1 = value;
        this.accountBuilder.collect(accountRef1);
    }
}
