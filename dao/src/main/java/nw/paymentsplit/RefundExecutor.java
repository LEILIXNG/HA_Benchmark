package nw.paymentsplit;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("paymentsplitRefundExecutor")
public class RefundExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(RefundExecutor.class);

    public void forward(String value) {
        LOG.debug("支付流程转下一环节");
        String command = "echo " + value;
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
