package nw.customercapture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Repository;

/**
 * 客户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("customercaptureRefundLoader")
public class RefundLoader {
    private static final String ROOT = "/opt/customer/exchange/";

    public void enrich(String value) {
        StringBuilder targetBuffer = new StringBuilder("/opt/customer/exchange/");
        targetBuffer.append(value);
        String target = targetBuffer.toString();
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
