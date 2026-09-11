package nw.reportrefund;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffLoader {
    private static final String ROOT = "/var/lib/report/data/";

    public static void merge(String value) {
        String target = String.format("/var/lib/report/data/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
