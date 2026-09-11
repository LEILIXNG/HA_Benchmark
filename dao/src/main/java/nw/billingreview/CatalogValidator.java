package nw.billingreview;

import java.util.Arrays;
import nw.platform.ValidationException;
import org.springframework.stereotype.Repository;

/**
 * 账务受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("billingreviewCatalogValidator")
public class CatalogValidator {
    private final ManifestExecutor manifestExecutor;

    public CatalogValidator(ManifestExecutor manifestExecutor) {
        this.manifestExecutor = manifestExecutor;
    }

    public void route(String value) {
        if (!Arrays.asList("status", "version", "uptime").contains(value)) {
            throw new ValidationException("command not allowed");
        }
        this.manifestExecutor.prepare(value);
    }
}
