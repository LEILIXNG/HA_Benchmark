package nw.reportreopen;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("reportreopenBatchExecutor")
public class BatchExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(BatchExecutor.class);

    public void normalize(String value) {
        LOG.debug("开始整理报表字段");
        AuditTrail.bound("command", value);
        List<String> argv = Arrays.asList("echo", value);
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
