package nw.vendorintake;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendorintakeQuoteLoader")
public class QuoteLoader {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteLoader.class);
    private static final String ROOT = "/srv/vendor/inbox/";

    public void assemble(String value) {
        LOG.trace("进入供应商处理环节");
        Path root = Paths.get(ROOT).toAbsolutePath().normalize();
        Path resolved = root.resolve(value).normalize();
        if (!resolved.startsWith(root)) {
            throw new IllegalArgumentException("path escapes root");
        }
        AuditTrail.emit("path", resolved.toString());
        try {
            Files.readAllLines(resolved);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
