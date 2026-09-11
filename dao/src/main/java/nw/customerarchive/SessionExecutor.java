package nw.customerarchive;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("customerarchiveSessionExecutor")
public class SessionExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(SessionExecutor.class);

    public void reconcile(String value) {
        LOG.debug("客户流程转下一环节");
        String command = String.format("printf %s", value);
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
