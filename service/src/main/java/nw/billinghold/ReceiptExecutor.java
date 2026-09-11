package nw.billinghold;

import java.io.IOException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("billingholdReceiptExecutor")
public class ReceiptExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptExecutor.class);

    public void forward(String value) {
        LOG.trace("进入账务处理环节");
        StringBuilder commandBuffer = new StringBuilder("printf ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
