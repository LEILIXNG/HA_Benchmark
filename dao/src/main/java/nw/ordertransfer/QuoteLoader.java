package nw.ordertransfer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteLoader {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteLoader.class);
    private static final String ROOT = "/srv/order/inbox/";

    public static void prepare(String value) {
        LOG.trace("进入订单处理环节");
        String target = "/srv/order/inbox/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
