package nw.pricingrevise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import nw.platform.ValidationException;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingreviseCatalogLoader")
public class CatalogLoader {
    private static final String ROOT = "/opt/pricing/exchange/";

    public void refine(String value) {
        String target = "/opt/pricing/exchange/".concat(value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
