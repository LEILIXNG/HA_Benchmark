package nw.paymentapprove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("paymentapproveController")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/api/payment/approve")
    public ResponseEntity<String> prepare(
            @RequestParam("label") String label) {
        LOG.trace("进入支付处理环节");
        CatalogAdapter.normalize(label);
        return ResponseEntity.ok("done");
    }
}
