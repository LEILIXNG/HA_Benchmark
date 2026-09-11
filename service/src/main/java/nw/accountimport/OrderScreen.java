package nw.accountimport;

import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("accountimportOrderScreen")
public class OrderScreen {
    private final ContractExecutor contractExecutor;

    public OrderScreen(ContractExecutor contractExecutor) {
        this.contractExecutor = contractExecutor;
    }

    public void route(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.contractExecutor.compose(value);
    }
}
