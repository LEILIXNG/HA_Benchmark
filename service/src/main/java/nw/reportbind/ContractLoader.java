package nw.reportbind;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("reportbindContractLoader")
public class ContractLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ContractLoader.class);
    private static final String ROOT = "/opt/report/exchange/";

    public void register(String value) {
        LOG.debug("开始整理报表字段");
        String target = "/opt/report/exchange/".concat(value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
