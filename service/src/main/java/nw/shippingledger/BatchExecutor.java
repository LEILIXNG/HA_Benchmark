package nw.shippingledger;

import java.io.IOException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("shippingledgerBatchExecutor")
public class BatchExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(BatchExecutor.class);

    public void normalize(String value) {
        LOG.debug("接收到一次发运处理请求");
        String command = "echo -n " + value;
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
