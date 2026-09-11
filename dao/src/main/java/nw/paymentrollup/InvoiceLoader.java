package nw.paymentrollup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Repository;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("paymentrollupInvoiceLoader")
public class InvoiceLoader {
    private static final String ROOT = "/var/lib/payment/data/";

    public void route(String value) {
        String target = String.format("/var/lib/payment/data/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
