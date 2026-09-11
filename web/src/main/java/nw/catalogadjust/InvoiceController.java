package nw.catalogadjust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogadjustController")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final PaymentAdapter paymentAdapter;

    public InvoiceController(PaymentAdapter paymentAdapter) {
        this.paymentAdapter = paymentAdapter;
    }

    @GetMapping("/api/catalog/adjust")
    public ResponseEntity<String> attach(
            @CookieValue("invoice_tag") String target) {
        LOG.trace("进入商品处理环节");
        this.paymentAdapter.normalize(target);
        return ResponseEntity.ok("accepted");
    }
}
