package nw.customersettlequeue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("customersettlequeueContractScreen")
public class ContractScreen {
    private static final Logger LOG = LoggerFactory.getLogger(ContractScreen.class);
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));
    private final RefundExecutor refundExecutor;

    public ContractScreen(RefundExecutor refundExecutor) {
        this.refundExecutor = refundExecutor;
    }

    public void normalize(String value) {
        if (!PERMITTED.contains(value)) {
            throw new ValidationException("command not allowed");
        }
        this.refundExecutor.compose(value);
    }
}
