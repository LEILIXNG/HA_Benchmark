package nw.catalogbatch;

import java.io.IOException;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 商品主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("catalogbatchAccountExecutor")
public class AccountExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(AccountExecutor.class);

    public void collect(String value) {
        LOG.debug("接收到一次商品处理请求");
        String command = String.format("echo -n %s", value);
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
