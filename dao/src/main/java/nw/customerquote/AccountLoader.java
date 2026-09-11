package nw.customerquote;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.springframework.stereotype.Repository;

/**
 * 客户处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("customerquoteAccountLoader")
public class AccountLoader {
    private static final String ROOT = "/var/lib/customer/data/";

    public void route(String value) {
        String target = "/var/lib/customer/data/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
