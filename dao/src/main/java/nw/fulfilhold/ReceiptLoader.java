package nw.fulfilhold;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ReceiptLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptLoader.class);
    private static final String ROOT = "/opt/fulfil/exchange/";

    public static void merge(String value) {
        LOG.debug("开始整理履约字段");
        String target = String.format("/opt/fulfil/exchange/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
