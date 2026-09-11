package nw.billingdispatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("billingdispatchChannelLoader")
public class ChannelLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelLoader.class);
    private static final String ROOT = "/srv/billing/inbox/";

    public void normalize(String value) {
        LOG.trace("进入账务处理环节");
        String target = "/srv/billing/inbox/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
