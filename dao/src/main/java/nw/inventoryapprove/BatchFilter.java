package nw.inventoryapprove;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("inventoryapproveBatchFilter")
public class BatchFilter {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));
    private final ReceiptExecutor receiptExecutor;

    public BatchFilter(ReceiptExecutor receiptExecutor) {
        this.receiptExecutor = receiptExecutor;
    }

    public void enrich(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        this.receiptExecutor.compose(value);
    }
}
