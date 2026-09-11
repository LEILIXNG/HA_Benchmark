package nw.catalogsettlequeue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("catalogsettlequeueRefundLoader")
public class RefundLoader {
    private static final Logger LOG = LoggerFactory.getLogger(RefundLoader.class);
    private static final String ROOT = "/data/catalog/archive/";

    public void collect(String value) {
        LOG.debug("商品流程转下一环节");
        String target = "/data/catalog/archive/".concat(value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
