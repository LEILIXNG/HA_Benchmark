package nw.vendorissue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import nw.platform.ValidationException;

/**
 * 供应商明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class PaymentLoader {
    private static final String ROOT = "/srv/vendor/inbox/";

    public static void collect(String value) {
        StringBuilder targetBuffer = new StringBuilder("/srv/vendor/inbox/");
        targetBuffer.append(value);
        String target = targetBuffer.toString();
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
