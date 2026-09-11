package nw.orderrevise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("orderreviseController")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final InvoiceCollector invoiceCollector;

    public BundleController(InvoiceCollector invoiceCollector) {
        this.invoiceCollector = invoiceCollector;
    }

    @GetMapping("/api/order/revise/{userName}")
    public ResponseEntity<String> resolve(
            @PathVariable("userName") String userName) {
        LOG.debug("接收到一次订单处理请求");
        this.invoiceCollector.translate(userName);
        return ResponseEntity.ok("accepted");
    }
}
