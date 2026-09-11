package nw.catalogrollup;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogrollupAccountPolicy")
public class AccountPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final ContractExecutor contractExecutor;

    public AccountPolicy(ContractExecutor contractExecutor) {
        this.contractExecutor = contractExecutor;
    }

    public void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        this.contractExecutor.prepare(value);
    }
}
