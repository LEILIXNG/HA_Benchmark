package nw.paymentrenewal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向支付场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("paymentrenewalController")
public class ManifestController {
    private final RefundResolver refundResolver;

    public ManifestController(RefundResolver refundResolver) {
        this.refundResolver = refundResolver;
    }

    @GetMapping("/api/payment/renewal/{userName}")
    public ResponseEntity<String> enrich(
            @PathVariable("userName") String userName) {
        this.refundResolver.refine(userName);
        return ResponseEntity.ok("accepted");
    }
}
