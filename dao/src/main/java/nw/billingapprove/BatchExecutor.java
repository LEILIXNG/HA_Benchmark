package nw.billingapprove;

import java.io.IOException;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Repository;

/**
 * 账务处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("billingapproveBatchExecutor")
public class BatchExecutor {

    public void register(String value) {
        String command = "printf ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
