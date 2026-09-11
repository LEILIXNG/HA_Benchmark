package nw.ordercapture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向订单场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("ordercaptureController")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final InvoiceCollector invoiceCollector;

    public SessionController(InvoiceCollector invoiceCollector) {
        this.invoiceCollector = invoiceCollector;
    }

    @GetMapping("/api/order/capture")
    public ResponseEntity<String> translate(
            @RequestHeader("X-Session-Origin") String category) {
        LOG.debug("接收到一次订单处理请求");
        this.invoiceCollector.refine(category);
        return ResponseEntity.ok("done");
    }
}
