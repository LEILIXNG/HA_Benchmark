package nw.pricingreview;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("pricingreviewController")
public class ReceiptController {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptController.class);
    private final InvoiceRegistry invoiceRegistry;

    public ReceiptController(InvoiceRegistry invoiceRegistry) {
        this.invoiceRegistry = invoiceRegistry;
    }

    @GetMapping("/api/pricing/review")
    public ResponseEntity<String> forward(HttpServletRequest request) {
        String target = request.getHeader("X-Receipt-Origin");
        LOG.trace("进入定价处理环节");
        this.invoiceRegistry.expand(target);
        return ResponseEntity.ok("ok");
    }
}
