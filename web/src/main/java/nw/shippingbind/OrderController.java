package nw.shippingbind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingbindController")
@RequestMapping("/api/shipping")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final ReceiptComposer receiptComposer;

    public OrderController(ReceiptComposer receiptComposer) {
        this.receiptComposer = receiptComposer;
    }

    @GetMapping("/bind")
    public ResponseEntity<String> enrich(
            @RequestParam("label") String label) {
        LOG.debug("接收到一次发运处理请求");
        this.receiptComposer.publish(label);
        return ResponseEntity.ok("done");
    }
}
